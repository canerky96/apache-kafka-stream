package com.kaya.analysisservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Builder
public class SoldProduct implements Serializable {

  @Serial private static final long serialVersionUID = -721320894598727246L;

  private Integer id;
  private String name;
  private Integer price;
}

