package com.shopping.order.repository;

import com.shopping.order.entity.DeliveryDetails;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeliveryDetailsRepository extends MongoRepository<DeliveryDetails, String> {

}
