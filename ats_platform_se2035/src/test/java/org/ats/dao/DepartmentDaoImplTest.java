package org.ats.dao;

import org.ats.entities.Department;
import org.ats.entities.Job;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class DepartmentDaoImplTest {
    private static DepartmentDao departmentDao;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        departmentDao = new DepartmentDaoImpl();
    }

    @Test
    void createDepartment1() {
        // Input
        Department dept = new Department();
        dept.setDepartmentName("IT");
        dept.setDescription("Admin IT");
        // Actual Result

        Department actualResult = departmentDao.createDepartment(dept);

        // Expected Result
        String expectedResult = "IT";

        // Compare
        Assertions.assertEquals(expectedResult, actualResult.getDepartmentName());
    }

    @Test
    void createDepartment2() {
        // Input
        Department dept = new Department();
        dept.setDepartmentName("HR");
        dept.setDescription("Human Resources");
        // Actual Result

        Department actualResult = departmentDao.createDepartment(dept);

        // Expected Result
        String expectedResult = "IT";

        // Compare
        Assertions.assertEquals(expectedResult, actualResult.getDepartmentName());
    }

    @Test
    void createDepartment3() {
        // Input
        Department dept = new Department();
        // Actual Result

        Department actualResult = departmentDao.createDepartment(dept);

        // Compare
        Assertions.assertThrows(Exception.class, () -> {
            throw new Exception("Test Exception");
        });
    }


    @Test
    void createDepartment4() {
        // Input
        Department dept = new Department();
        dept.setDepartmentName("FU.IT");
        dept.setDescription("Software");


        Job job8 = new Job();

        job8.setTitle("Cyber Security Engineer");
        job8.setDescription("""
        We are seeking a Cyber Security Engineer 
        experienced in penetration testing, SIEM, 
        vulnerability assessment, and cloud security.

        Responsibilities:
        - Monitor security incidents
        - Perform penetration testing
        - Improve security policies

        Benefits:
        - Security certification sponsorship
        - High performance bonus
        - Modern office environment
        """);

        job8.setLocation("Da Nang, Viet Nam");

        job8.setMinSalary(2500.00);
        job8.setMaxSalary(5000.00);

        job8.setStatus("OPEN");

        job8.setUtmSource("linkedin");
        job8.setUtmMedium("headhunt");

        job8.setDeadline(
                OffsetDateTime.of(
                        2027,
                        1,
                        10,
                        23,
                        59,
                        59,
                        0,
                        ZoneOffset.ofHours(7)
                )
        );

        job8.setPublishedAt(OffsetDateTime.now());
        job8.setDepartment(dept);

        Set<Job> jobs = new HashSet<>();
        jobs.add(job8);

        // Set job to department
        dept.setJobs(jobs);

        // Actual Results

        Department actualResult = departmentDao.createDepartment(dept);

        // Expected Result
        String expectedResult = "IVS";

        // Compare
        Assertions.assertEquals(expectedResult, actualResult.getDepartmentName());
    }


    @Test
    void findAll() {
        List<Department> departments = departmentDao.findAll();

        System.out.println(departments);

        Collections.sort(departments, (o1, o2) -> {
            return o1.getDepartmentName().compareTo(o2.getDepartmentName());
        });
    }


    @Test
    void findById() {
        // Input
        Long departmentId = 1L;
        //
        Department actualResult = departmentDao.findById(departmentId);

        System.out.println(actualResult.getJobs());

        Assertions.assertNotNull(actualResult);

    }
}