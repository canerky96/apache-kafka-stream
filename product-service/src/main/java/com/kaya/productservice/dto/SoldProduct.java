package com.kaya.productservice.dto;

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

  @Serial private static final long serialVersionUID = -7680637768557787325L;

  private Integer id;
  private String name;
  private Integer price;
}
