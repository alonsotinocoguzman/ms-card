package com.nttdata.mscard.service.impl;

import com.nttdata.mscard.model.entity.CustomerType;
import com.nttdata.mscard.proxy.service.MsProjectBankService;
import com.nttdata.mscard.service.CustomerTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerTypeImpl implements CustomerTypeService {
  private final MsProjectBankService msProjectBankService;

  @Override
  public List<CustomerType> getAllCustomerType() throws IOException {
    return msProjectBankService.getAllCustomerType();
  }
}
