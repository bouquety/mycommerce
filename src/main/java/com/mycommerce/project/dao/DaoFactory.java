package com.mycommerce.project.dao;


import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.dao.jpa.JpaCategoryDao;

public final class DaoFactory {

    private DaoFactory() {
    }

    public static ProductDao getMemoryProductDao() {
        return new MemoryProductDao();
    }

    public static CategoryDao getMemoryCategoryDao(){
        return  new MemoryCategoryDao();
    }
    public static JpaCategoryDao getJpaCategoryDao() {
        return new JpaCategoryDao();
    }


}