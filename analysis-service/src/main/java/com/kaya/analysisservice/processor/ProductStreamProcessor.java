package com.kaya.analysisservice.processor;

import com.kaya.analysisservice.dto.SoldProduct;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class ProductStreamProcessor {

  public static Map<Integer, Integer> products = new HashMap<>();

  @Autowired
  public void process(StreamsBuilder builder) {

    Serde<String> keySerde = Serdes.String();
    Serde<SoldProduct> valueSerde = new JsonSerde<>(SoldProduct.class);

    builder.stream("sold-product", Consumed.with(keySerde, valueSerde))
        .map((key, value) -> new KeyValue<>(value.getId(), value))
        .foreach(this::add);
  }

  private void add(Integer key, SoldProduct soldProduct) {
    products.put(key, products.getOrDefault(key, 0) + soldProduct.getPrice());
  }
}
