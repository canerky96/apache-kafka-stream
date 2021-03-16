package com.kaya.analysisservice.controller;

import com.kaya.analysisservice.processor.ProductStreamProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping
public class AnalysisController {

  @GetMapping
  public Map<Integer, Integer> getTotalPrice() {
    return ProductStreamProcessor.products;
  }
}
