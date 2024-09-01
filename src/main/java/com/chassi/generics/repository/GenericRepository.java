package com.chassi.generics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericRepository<T,ID> extends JpaRepository<T, ID> {
}
