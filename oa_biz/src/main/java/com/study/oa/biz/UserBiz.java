package com.study.oa.biz;

import com.study.oa.entity.Employee;

public interface UserBiz {
    Employee login(String sn ,String password);
    void changePassword(Employee employee);
}
