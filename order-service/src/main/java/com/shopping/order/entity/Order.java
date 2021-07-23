package com.shopping.order.entity;


import com.shopping.order.dto.ProductDto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

//Orders entity class used to map orders data into database

@Entity
@Table
public class Order implements Serializable {

	private static final long serialVersionUID = 8573273001577259969L;
	
	@Id
	@GeneratedValue
	private String Id;
	
	private String orderId;
	private String orderStatus;
	private String userId;
	private List<ProductDto> products;
	private double total;
	private String transactionId;

	public String getId() {
		return Id;
	}
	public void setId(String id) {
		Id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public List<ProductDto> getProducts() {
		return products;
	}
	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
