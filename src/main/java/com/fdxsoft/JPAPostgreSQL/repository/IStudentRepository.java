package com.fdxsoft.JPAPostgreSQL.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdxsoft.JPAPostgreSQL.domain.StudentEntity;

public interface IStudentRepository extends JpaRepository<StudentEntity, Long> {

}
