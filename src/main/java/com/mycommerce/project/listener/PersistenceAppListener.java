package com.mycommerce.project.listener;

import com.mycommerce.project.util.PersistenceManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class PersistenceAppListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent evt){
    }
    public void contextDestroyed(ServletContextEvent evt) {
        PersistenceManager.closeEntityManagerFactory();
    }
}