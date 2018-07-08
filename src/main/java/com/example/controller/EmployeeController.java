package com.example.controller;

import com.example.dao.EmployeeDao;
import com.example.entity.Employee;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class EmployeeController
{
    @Autowired
    private EmployeeDao employeeDao;

    @ResponseBody
    @RequestMapping(path = "/employees", method = RequestMethod.POST)
    public Employee createEmployee(@RequestBody @NotNull Employee employee)
    {
        return this.employeeDao.createEmployee(employee);
    }

    @ResponseBody
    @RequestMapping(path = "/employees", method = RequestMethod.GET)
    @ApiOperation(value = "Get all employees.")
    public List<Employee> getAllEmployees()
    {
        return this.employeeDao.getAllEmployees();
    }


}
