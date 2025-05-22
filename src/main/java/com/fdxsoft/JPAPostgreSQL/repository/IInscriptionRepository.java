package com.fdxsoft.JPAPostgreSQL.repository;

import org.springframework.data.repository.CrudRepository;
import com.fdxsoft.JPAPostgreSQL.domain.InscriptionEntity;

public interface IInscriptionRepository extends CrudRepository<InscriptionEntity, Long>{

}
