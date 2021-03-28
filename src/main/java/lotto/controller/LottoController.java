package lotto.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lotto.domain.Lotto;
import lotto.domain.LottoAgency;
import lotto.domain.Money;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {
  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  private static final InputView inputView = new InputView(reader);
  private static final OutputView outputView = new OutputView();

  private LottoAgency agency;
  private Lotto winNumbers;

  public void lottoResult() {
    OutputView.printResult(agency.getTotalResult(winNumbers));
  }

  public void userInput() throws IOException {
    Money money = inputView.howManyBuyLottoCoupon();
    initPhase(money);
    winNumbers = (inputView.enterWinnerNumbers());
  }

  private void initPhase(Money money) {
    agency = new LottoAgency(money);
    agency.purchaseLotto();
    outputView.printBoughtLottoCoupons(agency);
  }
}
