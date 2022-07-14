package com.nttdata.mscard.proxy.impl;

import com.nttdata.mscard.model.entity.Card;
import com.nttdata.mscard.model.entity.CustomerType;
import com.nttdata.mscard.proxy.api.MsProjectBankApi;
import com.nttdata.mscard.proxy.service.MsProjectBankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MsProjectBankServiceImpl implements MsProjectBankService {
  private final MsProjectBankApi msProjectBankApi;

  @Override
  public Card getBalanceByCustomerId(String id) throws IOException {
    Response<Card> cardResponse = msProjectBankApi.getBalanceByCustomerId(id).execute();
    if (!cardResponse.isSuccessful()) {
      throw new IOException(
          cardResponse.errorBody() != null
              ? cardResponse.errorBody().string()
              : "Error al consumir datos");
    }

    return cardResponse.body();
  }

  @Override
  public List<CustomerType> getAllCustomerType() throws IOException {
    Response<List<CustomerType>> customerTypeResponse =
        msProjectBankApi.getAllCustomerType().execute();
    if (!customerTypeResponse.isSuccessful()) {
      throw new IOException(
          customerTypeResponse.errorBody() != null
              ? customerTypeResponse.errorBody().string()
              : "Error al al obtener getAllCustomerTypes()");
    }
    return customerTypeResponse.body();
  }
}
