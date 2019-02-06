package com.sapient.order.rest.dto;



import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name="orders")
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Order implements Serializable{
	@Id
	private int id;
	private String item;
	private float price;
	private int quantity;
}
