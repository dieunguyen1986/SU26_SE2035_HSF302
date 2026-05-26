package org.ats.controller;

import org.ats.dto.DepartmentDto;
import org.ats.entities.Department;
import org.ats.services.DepartmentService;
import org.ats.services.DepartmentServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class DepartmentController {
    public static void main(String[] args) {
        DepartmentDto dto = new DepartmentDto();
        dto.setDepartmentName("Department 1");
        dto.setDescription("Department 1");

        ApplicationContext context = new AnnotationConfigApplicationContext("org.ats");
        DepartmentService departmentService = context.getBean("departmentService", DepartmentServiceImpl.class);
        departmentService.createDepartment(dto);

    }
}
