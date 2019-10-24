package com.study.oa.controller;

import com.study.oa.biz.DepartmentBiz;
import com.study.oa.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
@RequestMapping("/department")
public class DepartmentController {
    @Autowired
    DepartmentBiz departmentBiz;

    @RequestMapping("/list")
    public String list(Map<String,Object> map){
        map.put("list",departmentBiz.getAll());
        return "department_list";
    }
    @RequestMapping("/to_add")
    public String toadd(Map<String,Object> map){
        map.put("department",new Department());
        return "department_add";
    }
    @RequestMapping("/add")
    public String add(Department department){
        departmentBiz.add(department);
        return "redirect:list";
    }
    @RequestMapping("/to_update")
    public String toupdate(@RequestParam(value = "sn")String sn,Map<String,Object> map){
        map.put("department",departmentBiz.get(sn));
        return "department_update";
    }
    @RequestMapping("/update")
    public String update(@RequestParam(value = "sn")String sn,Department department){
        departmentBiz.edit(department);
        return "redirect:list";
    }
    @RequestMapping("/remove")
    public String remove(@RequestParam(value = "sn")String sn,Department department){
        departmentBiz.remove(sn);
        return "redirect:list";
    }

}
