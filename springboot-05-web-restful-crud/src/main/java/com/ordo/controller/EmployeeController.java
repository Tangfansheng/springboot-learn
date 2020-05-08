package com.ordo.controller;

import com.ordo.mybatis.dao.DepartmentDao;
import com.ordo.mybatis.dao.EmployeeDao;
import com.ordo.entities.Department;
import com.ordo.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao = new EmployeeDao();
    @Autowired
    DepartmentDao departmentDao = new DepartmentDao();
    //显示全部雇员
    @GetMapping("/emps")
    public String emp(Model model){
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "/emp/list";
    }

    //跳转到 -> 添加雇员表单
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //新增雇员
    //这里有SpringMVC自动封装：
    // 表单填好数据之后 直接可以被封装为一个Employee 要求是表单的属性名和入参的属性名一一对应
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //调试
        System.out.println(employee);
        employeeDao.save(employee);
        //redirect: 重定向到url:/emps
        //forward: 转发url:/emps
        return "redirect:emps";
    }

    //跳转到->修改雇员信息
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);
        //查出部门
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //修改雇员信息
    @PutMapping("/emp")
    public String editEmp(Employee employee){
        //调试
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除雇员
    @PostMapping("/emp/{id}")
    public String deleteEmp(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }

}
