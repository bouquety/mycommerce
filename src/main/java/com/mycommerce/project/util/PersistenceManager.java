package com.mycommerce.project.util;


import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceManager {
    private static EntityManagerFactory emf;

    public static EntityManagerFactory getEntityManagerFactory(){
        if(emf == null){
            emf = Persistence.createEntityManagerFactory("mycommerce");
        }
        return emf;
    }

    public static void closeEntityManagerFactory() {
        if(emf != null && emf.isOpen()) emf.close();
    }

}