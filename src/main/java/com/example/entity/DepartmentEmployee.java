package com.example.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "DEPARTMENT_EMPLOYEE")
public class DepartmentEmployee implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "is_deleted")
    private Boolean isDeleted;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "department_id")
    private Long departmentId;

    public Boolean isDeleted()
    {
        return this.isDeleted;
    }

    public void setDeleted(final Boolean isDeleted)
    {
        this.isDeleted = isDeleted;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public Long getEmployeeId()
    {
        return employeeId;
    }

    public void setEmployeeId(final Long id)
    {
        this.employeeId = id;
    }

    public Long getDepartmentId()
    {
        return this.departmentId;
    }

    public void setDepartmentId(final Long id)
    {
        this.departmentId = id;
    }


}
