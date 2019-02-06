package com.sapient.order.rest.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.order.rest.dto.Address;
import com.sapient.order.rest.dto.Order;
import com.sapient.order.rest.repository.IAddressRepository;
import com.sapient.order.rest.repository.OrderJPARepository;

@Service
public class OrderServiceImpl implements IOrderService {
	@Autowired
	private OrderJPARepository orderRepositoryImpl;

	@Autowired
	private IAddressRepository addressRepositoryImpl;

	public OrderServiceImpl() {
		System.out.println("OrderServiceImpl bean created");
	}

	/**
	 * 
	 * @param order
	 * @return order id
	 */
	// @Transactional(rollbackOn = Exception.class, dontRollbackOn =
	// IllegalAccessException.class)
	// For choosing propogation level use spring framework's transactional class
	@Transactional(timeout = 20, isolation = Isolation.READ_COMMITTED)
	public int processOrder(Order order) {
		orderRepositoryImpl.save(order);
		Address address = new Address();
		address.setHouseNumber("d/8");
		address.setPin(226003);
		addressRepositoryImpl.save(address);
		return order.getId();
	}

	@Transactional
	public void processdeleteOrder(int id) {
		// orderRepositoryImpl.delete(id);
		orderRepositoryImpl.deleteById(id);
		addressRepositoryImpl.delete(id);
	}

	@Transactional
	public Order processReadOrder(int id) {
		// Order order = orderRepositoryImpl.read(id);
		Order order = orderRepositoryImpl.getOne(id);
		addressRepositoryImpl.read(id);
		return order;
	}

	public List<Order> processReadOrder() {
		return orderRepositoryImpl.findAll();
		// return orderRepositoryImpl.read();
	}

}
