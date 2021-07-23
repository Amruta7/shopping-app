package com.shopping.order.model;


import com.shopping.order.dto.DeliveryAddressDto;
import com.shopping.order.dto.OrderDto;

public class ProcessOrderRequestModel {
	
	private PaymentDetailsRequestModel paymentDetails;
	
	private OrderDto orderDto;
	
	private DeliveryAddressDto deliveryAddressDetails;

	public PaymentDetailsRequestModel getPaymentDetails() {
		return paymentDetails;
	}

	public void setPaymentDetails(PaymentDetailsRequestModel paymentDetails) {
		this.paymentDetails = paymentDetails;
	}

	public OrderDto getOrderDto() {
		return orderDto;
	}

	public void setOrderDto(OrderDto orderDto) {
		this.orderDto = orderDto;
	}

	public DeliveryAddressDto getDeliveryAddressDetails() {
		return deliveryAddressDetails;
	}

	public void setDeliveryAddressDetails(DeliveryAddressDto deliveryAddressDetails) {
		this.deliveryAddressDetails = deliveryAddressDetails;
	}
	
	
	

}
