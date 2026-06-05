package org.ats.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;
import org.ats.entities.Department;
import org.ats.entities.Job;
import org.ats.utils.DbContext;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

//@Repository // IoC
public class DepartmentDaoImpl implements DepartmentDao {
    private EntityManager entityManager;

    public DepartmentDaoImpl() {
        entityManager = DbContext.getEntityManager();
    }

    /**
     *
     * @param dept
     * @return In JPA/Hibernate: change data (Insert, delete, update) -> transaction (tự quản lý)
     */
    @Override
    public Department createDepartment(Department dept) {
        entityManager = DbContext.getEntityManager();

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
            e.printStackTrace();
            throw new RuntimeException("Has an error occurred!");
        } finally {
            entityManager.close();
        }
        return dept;
    }

    @Override
    public Department findById(Long id) {
        try {
            entityManager = DbContext.getEntityManager();
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
    public boolean isExisted(String name) {
        entityManager = DbContext.getEntityManager();
        try (Session session = entityManager.unwrap(Session.class)) {
            Query<Long> query = session.createQuery("SELECT COUNT(d) FROM Department d WHERE d.departmentName = :param", Long.class);

            query.setParameter("param", name);

            Long amount = query.getSingleResult();

            return amount > 0;
        }

    }

    private static boolean extracted(Long amount) {
        return amount > 0;
    }

    @Override
    public List<Department> findAll() {
        TypedQuery<Department> query = entityManager.createQuery("SELECT d " +
                "FROM Department d", Department.class);
        return query.getResultList();
    }


}
