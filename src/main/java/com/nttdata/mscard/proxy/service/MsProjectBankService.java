package com.nttdata.mscard.proxy.service;

import com.nttdata.mscard.model.entity.Card;
import com.nttdata.mscard.model.entity.CustomerType;

import java.io.IOException;
import java.util.List;

public interface MsProjectBankService {
  Card getBalanceByCustomerId(String id) throws IOException;

  List<CustomerType> getAllCustomerType() throws IOException;
}
