package com.fdxsoft.JPAPostgreSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdxsoft.JPAPostgreSQL.domain.OneUseEntity;

public interface IOneUseRepository extends JpaRepository<OneUseEntity, Long>{

}
