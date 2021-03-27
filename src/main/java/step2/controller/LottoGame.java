package step2.controller;

import step2.domain.Cash;
import step2.view.InputView;

public class LottoGame {

  public void start() {
    int sellerMoney = InputView.starting();
    Cash cash = new Cash(sellerMoney);

  }
}
