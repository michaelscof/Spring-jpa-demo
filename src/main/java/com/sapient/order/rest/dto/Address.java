package com.sapient.order.rest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity(name = "address")
public class Address {
	@Id
	private int id;
	@Column(name = "house")
	private String houseNumber;
	private int pin;
}
