package com.jpa.repository;

import com.jpa.entity.Lifeboat;
import com.jpa.entity.LifeboatId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LifeboatRepository extends JpaRepository<Lifeboat, LifeboatId> {
}
