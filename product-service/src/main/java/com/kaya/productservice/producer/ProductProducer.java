package com.kaya.productservice.producer;

import com.kaya.productservice.dto.SoldProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor // Lombok annotations that creates constructors for final variables
public class ProductProducer {

  private final KafkaTemplate<String, SoldProduct> soldProductKafkaTemplate;

  public void send(SoldProduct soldProduct) {
    // sends soldProduct into 'sold-product' topic
    soldProductKafkaTemplate.send("sold-product", soldProduct);
  }
}
