package com.atguigu.springboot.spring04webrestfulcrud.controller;

import com.atguigu.springboot.spring04webrestfulcrud.dao.EmployeeDao;
import com.atguigu.springboot.spring04webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> all = employeeDao.getAll();
        System.out.println(all.size());
        model.addAttribute("emps",all);

        return "emp/list";
    }
}
