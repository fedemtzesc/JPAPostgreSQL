package com.fdxsoft.JPAPostgreSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdxsoft.JPAPostgreSQL.domain.CourseEntity;

public interface ICourseRepository extends JpaRepository<CourseEntity, Long>{
	
}
