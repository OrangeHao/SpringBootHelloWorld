package com.example.helloworld.db2.service;

import com.example.helloworld.bean.Money;
import com.example.helloworld.db2.dao.MoneyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MoneyService {

    @Autowired
    private MoneyDao moneyDao;

    /**
     * 根据名字查找用户
     */
    public Money selectMoneyById(int id) {
        return moneyDao.findMoneyById(id);
    }

}
