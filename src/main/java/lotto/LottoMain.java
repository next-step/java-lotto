package lotto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lotto.domain.LottoAgency;
import lotto.domain.Money;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoMain {
  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  private static final InputView inputView = new InputView(reader);
  private static final OutputView outputView = new OutputView();

  private LottoAgency agency;

  public static void main(String[] args) throws IOException {
    LottoMain main = new LottoMain();
    main.userInput();
    main.lottoResult();
  }

  private void lottoResult() {
    OutputView.printResult(agency.getTotalResult());
  }

  private void userInput() throws IOException {
    Money money = inputView.howManyBuyLottoCoupon();
    initPhase(money);
    agency.updateWinLottoNumbers(inputView.enterWinnerNumbers());
  }

  private void initPhase(Money money) {
    agency = new LottoAgency(money);
    agency.purchaseLotto();
    outputView.printBoughtLottoCoupons(agency);
  }
}
