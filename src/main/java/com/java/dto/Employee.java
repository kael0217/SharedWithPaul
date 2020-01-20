package com.java.dto;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.java.service.CustomAddressSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Employee {
	@Id
	int id;
	String name;
	@Embedded
	@JsonSerialize(using = CustomAddressSerializer.class)
	Address address;
}
