package com.kaya.productservice.producer;

import com.kaya.productservice.dto.SoldProduct;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductProducer {

  private final KafkaTemplate<String, SoldProduct> soldProductKafkaTemplate;

  public void send(SoldProduct soldProduct) {
    soldProductKafkaTemplate.send("sold-product", soldProduct);
  }
}
