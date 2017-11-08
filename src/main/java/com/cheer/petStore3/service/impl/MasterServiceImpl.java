/**
 * 
 */
package com.cheer.petStore3.service.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.cheer.petStore3.dao.MasterDao;
import com.cheer.petStore3.dao.PetDao;
import com.cheer.petStore3.dao.PetTypeDao;
import com.cheer.petStore3.dao.impl.MasterDaoImpl;
import com.cheer.petStore3.dao.impl.PetDaoImpl;
import com.cheer.petStore3.dao.impl.PetTypeDaoImpl;
import com.cheer.petStore3.domain.Master;
import com.cheer.petStore3.domain.Pet;
import com.cheer.petStore3.domain.PetType;
import com.cheer.petStore3.service.MasterService;

public class MasterServiceImpl implements MasterService
{
    private static final Logger LOGGER = LogManager.getLogger(MasterServiceImpl.class);

    @Override
    public boolean login(Master master, Session session, Transaction tx)
    {
        MasterDao masterDao = new MasterDaoImpl();
        if (masterDao.findMaster(master, session, tx) == 0)
        {
            LOGGER.info("登陆失败");
            return false;
        }

        LOGGER.info("登陆成功");
        return true;
    }

    @Override
    public boolean adoptPet(Session session, Transaction tx)
    {
        Scanner sc = new Scanner(System.in);
        String username = null;
        String password = null;
        String select = null;
        String name = null;
        String typeId = null;
        PetType petType = null;

        System.out.println("----欢迎光临宠物乐园----");
        System.out.println("请输入登入名：");
        username = sc.next();
        System.out.println("请输入密码：");
        password = sc.next();
        Master master = new Master(username, password);
        if (!login(master, session, tx))
        {
            sc.close();
            return false;
        }

        System.out.println("请选择宠物类型：");
        PetTypeDao petTypeDao = new PetTypeDaoImpl();
        List<PetType> petTypes = petTypeDao.findAllPetType(session, tx);
        List<String> petTypeNames = new ArrayList<>();

        StringBuffer sb = new StringBuffer();
        for (PetType element : petTypes)
        {
            petTypeNames.add(element.getName());
            sb.append(element.getName()).append(" | ");
        }

        LOGGER.info(sb);

        select = sc.next();
        if (!petTypeNames.contains(select))
        {
        	System.out.println("宠物类型输入有误，领养失败！");
            sc.close();
            return false;
        }

        for (PetType element : petTypes)
        {
            if (select.equals(element.getName()))
            {
                typeId = element.getId();
                petType = element;
                break;
            }
        }

        LOGGER.info("您选择的宠物类型编号是{}", typeId);
        System.out.println("请输入宠物昵称：");
        name = sc.next();

        sc.close();
        LOGGER.info(petType);
        Pet pet = new Pet(username, name, petType, 60, 0, new Date(System.currentTimeMillis()),
            "良好");
        PetDao petDao = new PetDaoImpl();

        petDao.save(pet, session, tx);

        return true;

    }
}