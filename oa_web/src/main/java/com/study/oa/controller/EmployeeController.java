package com.study.oa.controller;

import com.study.oa.biz.DepartmentBiz;
import com.study.oa.biz.EmployeeBiz;
import com.study.oa.entity.Employee;
import com.study.oa.global.Contant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    DepartmentBiz departmentBiz;
    @Autowired
    EmployeeBiz employeeBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",employeeBiz.getAll());
        return "employee_list";
    }
    @RequestMapping("/to_add")
    public String toadd(Map<String,Object> map){
        map.put("employee",new Employee());
        map.put("dlist",departmentBiz.getAll());
        map.put("plist",Contant.getPost());
        return "employee_add";
    }
    @RequestMapping("/add")
    public String add(Employee employee){
        employeeBiz.add(employee);
        return "redirect:list";
    }
    @RequestMapping("/to_update")
    public String toupdate(@RequestParam(value = "sn")String sn, Map<String,Object> map){
        map.put("employee",employeeBiz.get(sn));
        map.put("dlist",departmentBiz.getAll());
        map.put("plist",Contant.getPost());
        return "employee_update";
    }
    @RequestMapping("/update")
    public String update(@RequestParam(value = "sn")String sn,Employee employee){
        employeeBiz.edit(employee);
        return "redirect:list";
    }
    @RequestMapping("/remove")
    public String remove(@RequestParam(value = "sn")String sn,Employee employee){
        employeeBiz.remove(sn);
        return "redirect:list";
    }
    @RequestMapping("/remove_list")
    public String remove(@RequestParam(value = "sn_list") List<String> sn_list, Employee employee){
        for (String sn:sn_list){
            employeeBiz.remove(sn);
        }
        return "redirect:list";
    }

}
