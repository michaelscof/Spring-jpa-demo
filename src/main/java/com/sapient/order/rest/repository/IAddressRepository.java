package com.sapient.order.rest.repository;

import com.sapient.order.rest.dto.Address;

public interface IAddressRepository {
	void save(Address address);

	void delete(int id);

	Address read(int id);
}
