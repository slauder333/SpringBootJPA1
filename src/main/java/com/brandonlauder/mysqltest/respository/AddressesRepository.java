package com.brandonlauder.mysqltest.respository;

import com.brandonlauder.mysqltest.model.Addresses;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

public interface AddressesRepository extends CrudRepository<Addresses, Integer>, JpaSpecificationExecutor<Addresses> {
}
