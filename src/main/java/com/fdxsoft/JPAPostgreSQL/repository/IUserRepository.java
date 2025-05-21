package com.fdxsoft.JPAPostgreSQL.repository;

import com.fdxsoft.JPAPostgreSQL.domain.UserEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<UserEntity, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar por nombre de usuario
    // List<UserEntity> findByUserName(String userName);
}
