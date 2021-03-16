package com.kaya.analysisservice.controller;

import com.kaya.analysisservice.processor.ProductStreamProcessor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class AnalysisController {

  @GetMapping
  public Integer getTotalPrice() {
    return ProductStreamProcessor.count.get();
  }
}
