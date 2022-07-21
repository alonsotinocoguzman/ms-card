package com.nttdata.mscard.service;

import com.nttdata.mscard.model.entity.CustomerType;

import java.io.IOException;
import java.util.List;

public interface CustomerTypeService {
  List<CustomerType> getAllCustomerType() throws IOException;
}
