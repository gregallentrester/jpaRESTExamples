package com.example.jpa;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface VendorRepository extends CrudRepository<Vendor, Long> {

	List<Vendor> findByProduct(String product);

	Vendor findById(long id);
}
