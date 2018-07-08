package com.example.entity;

import org.hibernate.annotations.Where;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "EMPLOYEE")
public class Employee implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @Where(clause = "is_deleted = false")
    private Department department;

    @Column(name = "is_deleted", nullable = false)
    private Boolean isDeleted = false;

    public Long getId()
    {
        return id;
    }

    public void setId(final Long id)
    {
        this.id = id;
    }

    public Boolean isDeleted()
    {
        return isDeleted;
    }

    public void setDeleted(final Boolean deleted)
    {
        isDeleted = deleted;
    }

    public String getName()
    {
        return name;
    }

    public void setName(final String name)
    {
        this.name = name;
    }

    public Department getDepartment()
    {
        return department;
    }

    public void setDepartment(final Department department)
    {
        this.department = department;
    }
}
