package com.sapient.order.rest.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.order.rest.dto.Address;
import com.sapient.order.rest.dto.Order;

@Repository
public class AddressRepositoryImpl implements IAddressRepository {
	@PersistenceContext
	EntityManager entityManager; // session

	@Override
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save(Address address) {
		entityManager.persist(address);
	}

	@Override
	public void delete(int id) {
		Address address = new Address();
		address.setId(id);
		if (entityManager.contains(address))
			entityManager.remove(address);
		else
			entityManager.remove(entityManager.merge(address));
	}
	
	@Override
	public Address read(int id) {
		Address address = new Address();
		address.setId(id);
		address=entityManager.find(Address.class, id);
		return address;
	}
}