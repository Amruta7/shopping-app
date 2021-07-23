package com.shopping.order.repository;

import com.shopping.order.dto.OrderDto;
import com.shopping.order.entity.Order;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface OrderRepository extends MongoRepository<Order,String> {

	List<OrderDto> findByUserId(String userId);
}
