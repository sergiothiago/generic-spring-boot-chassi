package com.chassi.generics.service;

import com.chassi.generics.exceptions.ResourceNotFoundException;
import com.chassi.generics.repository.GenericRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public abstract class GenericService<T, ID> {

    @Autowired
    GenericRepository<T,ID> repository;

    public List<T> findAll(){
        return repository.findAll();
    }

    public <T> T findById(ID id) throws ResourceNotFoundException {
        return (T) repository.findById(id).orElseThrow( () ->
                new ResourceNotFoundException("Recurso de id" + id + " não encontrado "));
    }

    public T save(T t){
        return repository.save(t);
    }

    public T update(T t, ID id) throws ResourceNotFoundException {
        // Ensure that the entity exists before updating
        findById(id); // Throws exception if not found

        return repository.save(t);
    }

    public void deleteById(ID id) throws ResourceNotFoundException {
        // Ensure that the entity exists before deleting
        findById(id); // Throws exception if not found

        repository.deleteById(id);
    }
}
