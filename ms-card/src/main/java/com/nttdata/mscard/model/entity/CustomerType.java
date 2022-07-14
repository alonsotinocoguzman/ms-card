package com.nttdata.mscard.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerType {
  private String customerTypeId;
  private String customerTypeDescription;
}
