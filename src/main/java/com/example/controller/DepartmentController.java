package com.example.controller;

import com.example.dao.DepartmentDao;
import com.example.dto.DepartmentPatchDto;
import com.example.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class DepartmentController
{
    @Autowired
    private DepartmentDao departmentDao;

    @ResponseBody
    @RequestMapping(path = "/departments", method = RequestMethod.POST)
    Department postDepartment(@RequestBody @NotNull Department department)
    {
        return departmentDao.postDepartment(department);
    }
 
    @ResponseBody
    @RequestMapping(path = "/departments/{id}", method = RequestMethod.GET)
    Department getDepartment(@PathVariable(name = "id") @NotNull final Long id)
    {
        return departmentDao.getDepartment(id);
    }
    
    @ResponseBody
    @RequestMapping(path = "/departments", method = RequestMethod.GET)
    List<Department> getAllDepartments()
    {
        return departmentDao.getAllDepartments();
    }
    
    @ResponseBody
    @RequestMapping(path = "/departments/{id}", method = RequestMethod.PUT)
    Department putDepartment(@PathVariable(name = "id") @NotNull final Long id, @RequestBody @NotNull final Department department)
    {
        return departmentDao.putDepartment(department);
    }

    @ResponseBody
    @RequestMapping(path = "/departments/{id}", method = RequestMethod.PATCH)
    Department patchDepartment(@PathVariable(name = "id") @NotNull final Long id, @RequestBody @NotNull final DepartmentPatchDto patchDto)
    {
        return departmentDao.patchDepartmentSoftDelete(patchDto);
    }

    @ResponseBody
    @RequestMapping(path = "/departments/{id}/harddelete", method = RequestMethod.PATCH)
    Department patchDepartmentHardDeletesEmptyJoinCollection(@PathVariable(name = "id") @NotNull final Long id, @RequestBody @NotNull final DepartmentPatchDto patchDto)
    {
        return departmentDao.patchDepartmentHardDelete(patchDto);
    }
}
