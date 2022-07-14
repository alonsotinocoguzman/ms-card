package com.nttdata.mscard.controller;

import com.nttdata.mscard.UIUtils.Utils;
import com.nttdata.mscard.model.entity.CustomerType;
import com.nttdata.mscard.model.response.CardResponse;
import com.nttdata.mscard.service.CardService;
import com.nttdata.mscard.service.CustomerTypeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(Utils.BASEURL)
@CrossOrigin("*")
public class MsProjectBankController {
  private final CardService cardService;
  private final CustomerTypeService customerTypeService;

  @GetMapping(Utils.GET_BALANCE)
  public CardResponse getBalanceByCustomerId(@PathVariable(value = "id") String id)
      throws IOException {
    return cardService.getBalanceByCustomerId(id);
  }

  @GetMapping(Utils.GET_CUSTOMER)
  public List<CustomerType> getCustomerAll() throws IOException {
    return customerTypeService.getAllCustomerType();
  }
}
