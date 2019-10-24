package com.study.oa.biz.impl;

import com.study.oa.biz.UserBiz;
import com.study.oa.dao.EmployeeDao;
import com.study.oa.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserBizimpl implements UserBiz {
    @Autowired
    private EmployeeDao employeeDao;
    public Employee login(String sn, String password) {
        Employee e=employeeDao.select(sn);
        if(e!=null&&e.getPassword().equals(password)) {
            return e;
        }
        return null;
    }

    public void changePassword(Employee employee) {
        employeeDao.update(employee);
    }
}
