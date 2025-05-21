package com.fdxsoft.JPAPostgreSQL.repository;

import com.fdxsoft.JPAPostgreSQL.domain.ClientEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends CrudRepository<ClientEntity, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
    // Por ejemplo, buscar por nombre o apellido
    // List<ClientEntity> findByName(String name);
    // List<ClientEntity> findByLastName(String lastName);

}
