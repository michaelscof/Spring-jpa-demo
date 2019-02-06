package com.sapient.order.rest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.sapient.order.rest.dto.Order;
@Repository
public interface OrderJPARepository extends JpaRepository<Order, Integer> {
	/*@Query("select order from Orders where price=?1")
	List<Order> findByPrice(float price);*/
}
