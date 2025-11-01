package org.example.Collection;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Employee implements  Comparable<Employee>{
    String name;
    String Department;

    Integer Salary ;

    List<String> skills;
    LocalDate hireDate;


    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public Employee(String name, String department, List<String> skill, LocalDate hireDate) {
        this.name = name;
        Department = department;
        skills=skill;
        this.hireDate=hireDate;
    }


    public Integer getSalary() {
        return Salary;
    }

    public void setSalary(Integer salary) {
        Salary = salary;
    }

    public Employee(String name, String department, List<String> skills, Integer salary) {
        this.name = name;
        Department = department;
        Salary = salary;
        this.skills = skills;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return Department;
    }

    public void setDepartment(String department) {
        Department = department;
    }

    @Override
    public int compareTo(Employee o) {
        return this.name.compareTo(o.getName());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(Department, employee.Department) && Objects.equals(Salary, employee.Salary) && Objects.equals(skills, employee.skills);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", Department='" + Department + '\'' +
                ", Salary=" + Salary +
                ", skills=" + skills +
                ", hireDate=" + hireDate +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Department, Salary, skills);
    }
}
