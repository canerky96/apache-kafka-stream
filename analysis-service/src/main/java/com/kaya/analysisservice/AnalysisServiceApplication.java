package com.kaya.analysisservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@SpringBootApplication

public class AnalysisServiceApplication {

  public static void main(String[] args) {
    SpringApplication.run(AnalysisServiceApplication.class, args);
  }
}
