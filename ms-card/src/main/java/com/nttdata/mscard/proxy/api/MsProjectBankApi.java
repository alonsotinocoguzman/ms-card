package com.nttdata.mscard.proxy.api;

import com.nttdata.mscard.model.entity.Card;
import com.nttdata.mscard.model.entity.CustomerType;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

import java.util.List;

public interface MsProjectBankApi {
  @GET("/card/debit-credit/{id}")
  Call<Card> getBalanceByCustomerId(@Path("id") String id);

  @GET("/customertype/find-all")
  Call<List<CustomerType>> getAllCustomerType();
}
