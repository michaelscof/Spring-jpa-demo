package com.sapient.order.rest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.sapient.order.rest.dto.Order;

//@Repository
public class OrderRepositoryImpl implements IOrderRepository {
	@PersistenceContext
	EntityManager entityManager;

	@Override
	public void save(Order order) {
		entityManager.persist(order);
	}

	@Override
	public void delete(int id) {
		Order order = new Order();
		order.setId(id);
		if (entityManager.contains(order))
			entityManager.remove(order);
		else
			entityManager.remove(entityManager.merge(order));
	}

	@Override
	public Order read(int id) {
		return entityManager.find(Order.class, id);
	}

	@Override
	public List<Order> read() {
		Query query= entityManager.createQuery("from orders");
		List<Order> orders=query.getResultList();
		return orders;
	}
}
