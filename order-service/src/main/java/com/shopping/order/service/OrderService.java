package com.shopping.order.service;

import com.shopping.order.dto.DeliveryAddressDto;
import com.shopping.order.dto.OrderDto;
import com.shopping.order.dto.PaymentDto;
import com.shopping.order.dto.ReviewDto;

import java.util.List;

public interface OrderService {

	void addReview(ReviewDto reviewDto);

	OrderDto processCheckout(OrderDto checkoutDto);

	OrderDto proceedPayment(PaymentDto paymentDto, OrderDto orderDto, DeliveryAddressDto deliveryDetails);

	List<OrderDto> viewOrders(String userId);
	
	

}
