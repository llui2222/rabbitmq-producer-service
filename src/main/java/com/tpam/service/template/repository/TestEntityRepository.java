package com.tpam.service.template.repository;

import com.tpam.service.template.model.TestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestEntityRepository extends JpaRepository<TestEntity, Integer> {
}
