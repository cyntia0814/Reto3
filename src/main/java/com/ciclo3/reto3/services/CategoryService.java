package com.ciclo3.reto3.services;

import com.ciclo3.reto3.entities.Admin;
import com.ciclo3.reto3.entities.Category;
import com.ciclo3.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category c){
        if(c.getId()==null){
            return categoryRepository.save(c);
        }else{
            Optional<Category> cateaux= categoryRepository.getCategory(c.getId());
            if (cateaux.isPresent()){
                return categoryRepository.save(c);
            }else {
                return c;
            }
        }
    }
    public Category update(Category c) {
        if (c.getId() != null) {
            Optional<Category> cat = categoryRepository.getCategory(c.getId());
            if (cat.isPresent()) {
                Category oldCat = cat.get();
                if (c.getName() != null) {
                    oldCat.setName(c.getName());
                }
                if (c.getDescription() != null) {
                    oldCat.setDescription(c.getDescription());
                }
                return categoryRepository.save(oldCat);
            }
        }
        return c;
    }

    public boolean delete(int id) {
        Optional<Category> Cate = categoryRepository.getCategory(id);
        if (Cate.isPresent()) {
            categoryRepository.delete(Cate.get());
            return true;
        } else {
            return false;
        }
    }
}
