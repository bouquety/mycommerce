package com.mycommerce.project.dao.jpa;


import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.model.Category;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.io.Serializable;
import java.util.List;

public class JpaCategoryDao implements CategoryDao, Serializable {

    public JpaCategoryDao() {
    }



    EntityManagerFactory emf = Persistence.createEntityManagerFactory("mycommerce");
    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();

   



    @Override
    public Long add(Category category) {
        et.begin();

        try {
            String query = "insert into category values(?,?)";
            Long id = category.getId();
            String name = category.getName();

            em.createNativeQuery(query)
                    .setParameter(1, id)
                    .setParameter(2, name)
                    .executeUpdate();
            em.persist(category);
            em.getTransaction().commit();
            return id;
        } catch (RuntimeException re) {
            if (et.isActive())
                et.rollback();
            return null;
        }finally {
            em.close();
        }



    }

    @Override
    public void update(Category var1) {
        //TODO
    }

    @Override
    public Category findById(Long var1) {
        et.begin();
        try {
            Category category = em.find(Category.class, var1);
            return category;
        } catch (RuntimeException re) {
            if (et.isActive())
                et.rollback();
            return null;
        }

    }


    @Override
    public List<Category> getAll() {
        return em.createQuery("select c from Category c", Category.class)
                .getResultList();
    }

    @Override
    public void remove(Category var1) {
        try {
            Category category = em.find(Category.class, var1);
            em.remove(category);
            et.commit();
        } catch (RuntimeException re) {
            if (et.isActive())
                et.rollback();
        }
    }

    @Override
    public void remove(Long id) {
        try {
            Category category = em.find(Category.class, id);
            em.remove(category);
            et.commit();
        } catch (RuntimeException re) {
            if (et.isActive())
                et.rollback();
        }
    }
}
