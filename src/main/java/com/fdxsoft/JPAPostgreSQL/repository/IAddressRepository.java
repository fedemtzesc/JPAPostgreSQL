package com.fdxsoft.JPAPostgreSQL.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.fdxsoft.JPAPostgreSQL.domain.AddressEntity;

@Repository
public interface IAddressRepository extends CrudRepository<AddressEntity, Long> {

}
