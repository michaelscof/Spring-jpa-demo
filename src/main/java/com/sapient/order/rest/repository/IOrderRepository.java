package com.sapient.order.rest.repository;

import java.util.List;

import com.sapient.order.rest.dto.Order;

public interface IOrderRepository {

	void save(Order order);

	void delete(int id);

	Order read(int id);

	List<Order> read();


}