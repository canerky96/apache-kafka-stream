package com.kaya.productservice.job;

import com.kaya.productservice.dto.SoldProduct;
import com.kaya.productservice.producer.ProductProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Configuration
@EnableScheduling
@RequiredArgsConstructor
public class TestScheduler {

  private final ProductProducer productProducer;

  @Scheduled(fixedDelay = 500)
  public void scheduleFixedDelayTask() {
    List<SoldProduct> soldProducts =
        Arrays.asList(
            SoldProduct.builder().id(1).name("Bread").price(10).build(),
            SoldProduct.builder().id(2).name("Milk").price(20).build(),
            SoldProduct.builder().id(3).name("Water").price(5).build());

    int index = ThreadLocalRandom.current().nextInt(0, soldProducts.size());
    productProducer.send(soldProducts.get(index));
  }
}
