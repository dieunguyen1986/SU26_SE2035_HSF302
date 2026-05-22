package org.ats;

import org.ats.dao.DepartmentDao;
import org.ats.dao.DepartmentDaoImpl;
import org.ats.entities.Department;

import java.util.HashSet;
import java.util.Set;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Department department = new Department();
        department.setDepartmentName("SE");
        department.setDescription("Software Engineering");


        Department department2 = new Department();
        department2.setDepartmentName("SE");
        department2.setDescription("Software Engineering");

        Set<Department> departments = new HashSet<>();
        departments.add(department);
        departments.add(department2);
        System.out.println("Department size: " + departments.size());


//        DepartmentDao departmentDao = new DepartmentDaoImpl();
//        Department result = departmentDao.createDepartment(department);
//        System.out.println(result);
//
//        departmentDao.findAll().forEach(System.out::println);
    }
}