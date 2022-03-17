package com.mycommerce.project.dao;


import com.mycommerce.project.dao.base.CategoryDao;
import com.mycommerce.project.dao.base.ProductDao;
import com.mycommerce.project.dao.exception.UnknownProductException;
import com.mycommerce.project.model.Category;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class MemoryCategoryDao implements CategoryDao {

    private static List<Category> categorys = new ArrayList();
    private static Long idSequence = 1L;

    MemoryCategoryDao() {
    }

    @Override
    public Long add(Category category) {
        Long var1 = idSequence;
        idSequence = idSequence + 1L;
        category.setId(var1);
        categorys.add(category);
        return var1;
    }

    @Override
    public void update(Category category) {
        int index = this.getCategoryIndexById(category.getId());
        if (index > -1) {
            categorys.set(index, category);
        } else {
            throw new UnknownProductException(category.getId());
        }
    }

    @Override
    public Category findById(Long id) {
        int index = this.getCategoryIndexById(id);
        if (index > -1) {
            Category category = (Category) categorys.get(index);
            return category;
        } else {
            throw new UnknownProductException(id);
        }
    }

    @Override
    public List<Category> getAll() {
        return Collections.unmodifiableList(categorys);
    }

    @Override
    public void remove(Category category) {
        this.remove(category.getId());
    }

    @Override
    public void remove(Long id) {
        int index = this.getCategoryIndexById(id);
        if (index > -1) {
            categorys.remove(index);
        } else {
            throw new UnknownProductException(id);
        }
    }

    private int getCategoryIndexById(Long id) {
        for (int i = 0; i < categorys.size(); ++i) {
            Category category = categorys.get(i);
            if (category.getId().equals(id)) {
                return i;
            }
        }

        return -1;
    }
}
