package com.sapient.order.rest.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.order.rest.dto.Order;
import com.sapient.order.rest.services.IOrderService;

@RestController("/orders")
public class OrderController {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
	@Autowired
	private IOrderService orderService;

//	@RequestMapping(method=RequestMethod.POST)
	@PostMapping
	public ResponseEntity createOrder(@RequestBody Order order) {
		logger.info("creating order...{}", order);
		ResponseEntity responseEntity;
		try {
			orderService.processOrder(order);
			responseEntity = new ResponseEntity(HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return responseEntity;
	}

	@DeleteMapping(value = "/orders/{id}")
	public ResponseEntity deleteOrder(@PathVariable int id) {
		logger.info("deleting order...id={}", id);
		ResponseEntity responseEntity;
		try {
			orderService.processdeleteOrder(id);
			responseEntity = new ResponseEntity(HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
		}
		return responseEntity;
	}

	@GetMapping(value = "/orders/{id}")
	public ResponseEntity readOrder(@PathVariable int id) {
		logger.info("reading order...id={}", id);
		ResponseEntity responseEntity = null;
		Order order = orderService.processReadOrder(id);
		if (order == null)
			responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
		else
			responseEntity = ResponseEntity.ok(order);
		return responseEntity;
	}

	@GetMapping("/orders")
	public List<Order> getAllOrders() {
		List<Order> orders=orderService.processReadOrder();
		return orders;
	}
}
