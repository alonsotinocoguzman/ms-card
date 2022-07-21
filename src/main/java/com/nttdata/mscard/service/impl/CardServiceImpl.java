package com.nttdata.mscard.service.impl;

import com.nttdata.mscard.model.entity.Card;
import com.nttdata.mscard.model.response.CardResponse;
import com.nttdata.mscard.proxy.service.MsProjectBankService;
import com.nttdata.mscard.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class CardServiceImpl implements CardService {
  private final MsProjectBankService msProjectBankService;

  @Override
  public CardResponse getBalanceByCustomerId(String id) throws IOException {
    Card cardResponse = msProjectBankService.getBalanceByCustomerId(id);
    return convertEntityToDto(cardResponse);
  }

  private CardResponse convertEntityToDto(Card card) {
    CardResponse cardDto = new CardResponse();
    cardDto.setAvailableBalance(card.getAvailableBalance());
    return cardDto;
  }
}
