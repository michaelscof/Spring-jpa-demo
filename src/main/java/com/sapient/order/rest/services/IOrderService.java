package com.sapient.order.rest.services;

import java.util.List;

import com.sapient.order.rest.dto.Order;

public interface IOrderService {
	int processOrder(Order order);

	void processdeleteOrder(int id);

	Order processReadOrder(int id);

	List<Order> processReadOrder();
}
