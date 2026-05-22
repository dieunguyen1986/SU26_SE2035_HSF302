package org.ats.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.TypedQuery;
import org.ats.entities.Department;
import org.ats.entities.Job;

import java.util.List;
import java.util.Set;

public class DepartmentDaoImpl implements DepartmentDao {
    private EntityManager entityManager;

    public DepartmentDaoImpl() {
        entityManager = Persistence.createEntityManagerFactory("ats-jpa-unit").createEntityManager();
    }

    /**
     *
     * @param dept
     * @return In JPA/Hibernate: change data (Insert, delete, update) -> transaction (tự quản lý)
     */
    @Override
    public Department createDepartment(Department dept) {
        EntityTransaction tx = null;
        try {
            tx = entityManager.getTransaction();
            tx.begin();

            entityManager.persist(dept);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw new RuntimeException("Has an error occurred!");
        } finally {
            entityManager.close();
        }
        return dept;
    }

    @Override
    public Department findById(Long id) {
        try {
            Department department = entityManager.find(Department.class, id);

            //Proxy Object
            Set<Job> jobs = department.getJobs();

            System.out.println(jobs);

            return department;

        } catch (Exception e) {
            throw new RuntimeException("Has an error occurred!");
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<Department> findAll() {
        TypedQuery<Department> query = entityManager.createQuery("SELECT d " +
                "FROM Department d", Department.class);
        return query.getResultList();
    }


}
