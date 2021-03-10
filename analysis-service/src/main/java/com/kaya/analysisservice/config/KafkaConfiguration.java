package com.kaya.analysisservice.config;

import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaConfiguration {

  @Bean
  KafkaStreamsConfiguration defaultKafkaStreamsConfig() {
    Map<String, Object> configs = new HashMap<>();
    configs.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
    configs.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
    configs.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, JsonSerde.class);
    configs.put(StreamsConfig.APPLICATION_ID_CONFIG, "analysis-service");
    return new KafkaStreamsConfiguration(configs);
  }
}
