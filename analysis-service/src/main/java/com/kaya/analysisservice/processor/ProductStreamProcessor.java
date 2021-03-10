package com.kaya.analysisservice.processor;

import com.kaya.analysisservice.dto.SoldProduct;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ProductStreamProcessor {

  private int count = 0;

  @Autowired
  public void process(StreamsBuilder builder) {

    Serde<String> keySerde = Serdes.String();
    Serde<SoldProduct> valueSerde = new JsonSerde<>(SoldProduct.class);


    builder.stream("sold-product", Consumed.with(keySerde, valueSerde))
        .peek((k, v) -> System.out.println(v))
        .foreach(this::apply);
  }

  private void apply(String key, SoldProduct value) {
    count = count + value.getPrice();
  }
}
