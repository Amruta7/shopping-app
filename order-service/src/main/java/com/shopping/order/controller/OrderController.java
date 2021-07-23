package com.shopping.order.controller;


import com.shopping.order.dto.DeliveryAddressDto;
import com.shopping.order.dto.OrderDto;
import com.shopping.order.dto.PaymentDto;
import com.shopping.order.dto.ReviewDto;
import com.shopping.order.model.*;
import com.shopping.order.service.OrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@GetMapping(path={"/view"},produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<List<OrderDto>> viewOrders(@RequestHeader("userId") String userId)
	{
		List<OrderDto> orders=orderService.viewOrders(userId);
		return ResponseEntity.status(HttpStatus.OK).body(orders);
	}
	
	
	@PostMapping(path={"/cart/checkout"},consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<CheckoutResponseModel> proceedCheckout(@RequestHeader("userId") String userId, @RequestBody CheckoutRequestModel checkoutRequestModel)
	{
		
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		OrderDto orderDto=modelMapper.map(checkoutRequestModel, OrderDto.class);
		orderDto.setUserId(userId);
		OrderDto order=orderService.processCheckout(orderDto);
		
		CheckoutResponseModel response=modelMapper.map(order, CheckoutResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping(path={"/cart/checkout/payment"},consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},produces={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<ProcessOrderResponseModel> proceedPayment(@RequestHeader("userId") String userId, @RequestBody ProcessOrderRequestModel processOrderRequestModel)
	{
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		PaymentDto paymentDto=modelMapper.map(processOrderRequestModel.getPaymentDetails(), PaymentDto.class);
		paymentDto.setUserId(userId);
		OrderDto orderDto=modelMapper.map(processOrderRequestModel.getOrderDto(),OrderDto.class);
		orderDto.setUserId(userId);
		DeliveryAddressDto deliveryDetails=modelMapper.map(processOrderRequestModel.getDeliveryAddressDetails(), DeliveryAddressDto.class);
		OrderDto order=orderService.proceedPayment(paymentDto,orderDto,deliveryDetails);
		ProcessOrderResponseModel response=modelMapper.map(order, ProcessOrderResponseModel.class);
		
		return ResponseEntity.status(HttpStatus.OK).body(response);
	}
	
	@PostMapping(path={"/product/review"},consumes={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public String addReview(@RequestHeader("userId") String userId,@RequestBody AddReviewRequestModel addReviewRequestModel)
	{
		ModelMapper modelMapper=new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ReviewDto review=modelMapper.map(addReviewRequestModel, ReviewDto.class);
		orderService.addReview(review);
		
		return "Successfully added your review.";
	}

	

}
