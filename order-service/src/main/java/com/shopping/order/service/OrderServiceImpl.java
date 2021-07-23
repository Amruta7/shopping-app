package com.shopping.order.service;

import com.shopping.order.dto.*;
import com.shopping.order.entity.DeliveryDetails;
import com.shopping.order.entity.Order;
import com.shopping.order.entity.PaymentDetails;
import com.shopping.order.entity.Review;
import com.shopping.order.repository.DeliveryDetailsRepository;
import com.shopping.order.repository.OrderRepository;
import com.shopping.order.repository.PaymentRepository;
import com.shopping.order.repository.ReviewRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class OrderServiceImpl implements OrderService {

	OrderRepository orderRepository;
	PaymentRepository paymentRepository;
	ReviewRepository reviewRepository;
	DeliveryDetailsRepository deliveryDetailsRepository;

	@Autowired
	public OrderServiceImpl(OrderRepository orderRepository, PaymentRepository paymentRepository, ReviewRepository reviewRepository, DeliveryDetailsRepository deliveryDetailsRepository) {
		this.orderRepository = orderRepository;
		this.paymentRepository = paymentRepository;
		this.reviewRepository=reviewRepository;
		this.deliveryDetailsRepository=deliveryDetailsRepository;
	}
	
	@Override
	public List<OrderDto> viewOrders(String userId) {
		return orderRepository.findByUserId(userId);
	}

	@Override
	public OrderDto processCheckout(OrderDto orderDto) {
		
		double total=0;
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<ProductDto> products=orderDto.getProducts();
		for(ProductDto product : products)
		{
			total=total+(product.getPrice()*Integer.parseInt(product.getQuantity()));
		}
		orderDto.setTotal(total);
		orderDto.setOrderStatus("Pending");
		return orderDto;
	}
	
	@Override
	public OrderDto proceedPayment(PaymentDto paymentDto, OrderDto orderDto, DeliveryAddressDto deliveryDetailsDto) {
		
		String orderId=UUID.randomUUID().toString();
		String transactionId=UUID.randomUUID().toString();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		PaymentDetails transaction=modelMapper.map(paymentDto, PaymentDetails.class);
		transaction.setOrderId(orderId);
		transaction.setTransactionId(transactionId);
		paymentRepository.save(transaction);
		orderDto.setOrderId(orderId);
		Order order=modelMapper.map(orderDto, Order.class);
		order.setOrderStatus("Completed");
		order.setTransactionId(transactionId);
		orderRepository.save(order);
		deliveryDetailsDto.setOrderId(orderId);
		DeliveryDetails deliveryDetails=modelMapper.map(deliveryDetailsDto, DeliveryDetails.class);
		deliveryDetailsRepository.save(deliveryDetails);
		OrderDto orderResponse=modelMapper.map(order, OrderDto.class);
		
		return orderResponse;
	}

	@Override
	public void addReview(ReviewDto reviewDto) {
		
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Review review = modelMapper.map(reviewDto, Review.class);
		reviewRepository.save(review);
		
	}

	
}
