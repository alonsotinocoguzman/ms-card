package com.nttdata.mscard.service;

import com.nttdata.mscard.model.response.CardResponse;

import java.io.IOException;

public interface CardService {
  CardResponse getBalanceByCustomerId(String id) throws IOException;
}
