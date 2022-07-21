package com.nttdata.mscard.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CardResponse {
  private String numberAccount;
  private Double availableBalance;
  private Double loadBalance;
  private Double debitBalance;
  private Double creditLimit;
  private String customerId;
}
