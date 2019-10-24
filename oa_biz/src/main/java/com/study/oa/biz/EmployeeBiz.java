package com.study.oa.biz;

import com.study.oa.entity.Department;
import com.study.oa.entity.Employee;

import java.util.List;

public interface EmployeeBiz {
    void add(Employee Employee);
    void edit(Employee Employee);
    void remove(String sn);
    Employee get(String sn);
    List<Employee> getAll();
}
