package com.kaya.analysisservice.processor;

import com.kaya.analysisservice.dto.SoldProduct;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.KeyValue;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.Consumed;
import org.apache.kafka.streams.kstream.TimeWindows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.support.serializer.JsonSerde;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@RequiredArgsConstructor
public class ProductStreamProcessor {

  public static final AtomicInteger count = new AtomicInteger();

  @Autowired
  public void process(StreamsBuilder builder) {

    Serde<String> keySerde = Serdes.String();
    Serde<SoldProduct> valueSerde = new JsonSerde<>(SoldProduct.class);

    builder.stream("sold-product", Consumed.with(keySerde, valueSerde))
        .map((key, value) -> new KeyValue<>(value.getId().toString(), value))
        .groupByKey()
        .windowedBy(TimeWindows.of(Duration.ofSeconds(10)))
        .count()
        .toStream()
        .map((key, value) -> new KeyValue<>(key.key(), value))
        .foreach((key, value) -> increase(value.intValue()));
  }

  private void increase(Integer value) {
    count.addAndGet(value);
  }
}
