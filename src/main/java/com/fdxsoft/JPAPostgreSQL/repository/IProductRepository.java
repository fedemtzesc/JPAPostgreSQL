package com.fdxsoft.JPAPostgreSQL.repository;

import org.springframework.data.repository.CrudRepository;

import com.fdxsoft.JPAPostgreSQL.domain.ProductEntity;

public interface IProductRepository extends CrudRepository<ProductEntity, Long>{

}
