package com.atguigu.springboot.spring04webrestfulcrud.controller;

import com.atguigu.springboot.spring04webrestfulcrud.dao.DepartmentDao;
import com.atguigu.springboot.spring04webrestfulcrud.dao.EmployeeDao;
import com.atguigu.springboot.spring04webrestfulcrud.entities.Department;
import com.atguigu.springboot.spring04webrestfulcrud.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.jws.WebParam;
import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    
    @Autowired
    DepartmentDao departmentDao;
    
    @GetMapping("/emps")
    public String list(Model model){

        Collection<Employee> all = employeeDao.getAll();
        System.out.println(all.size());
        model.addAttribute("emps",all);

        return "emp/list";
    }

    //员工添加页面
    @GetMapping("/emp")
    public String toAddEmp(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }

    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee){

        System.out.println(employee);
        employeeDao.save(employee);
        //来到员工列表页面redirect:  重定向  forward: 转发
        return "redirect:/emps";
    }

    //来打修改页面，查处当前员工，在页面回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model ){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        return "emp/update";
    }

    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
