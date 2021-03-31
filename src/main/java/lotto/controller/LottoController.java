package lotto.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import lotto.domain.Lotto;
import lotto.domain.LottoAgency;
import lotto.domain.Money;
import lotto.domain.Number;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {
  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

  private static final InputView inputView = new InputView(reader);
  private static final OutputView outputView = new OutputView();

  private final LottoAgency agency;
  private final Lotto winNumbers;

  public LottoController() throws IOException {
    this.agency = createLottoAgency();
    buyLottoPhase();
    this.winNumbers = inputWinLottoNumbers();
    lottoResult();
  }

  public static void startLottoGame() throws IOException {
    new LottoController();
  }

  private void lottoResult() throws IOException {
    Number bonusBall = inputBonusBall();
    OutputView.printResult(agency.getLottoResult(winNumbers, bonusBall));
  }

  private LottoAgency createLottoAgency() throws IOException {
    return new LottoAgency(inputUserHowManyBuyLotto());
  }

  private Lotto inputWinLottoNumbers() throws IOException {
    return inputView.enterWinnerNumbers();
  }

  private Money inputUserHowManyBuyLotto() throws IOException {
    return inputView.howManyBuyLottoCoupon();
  }

  private Number inputBonusBall() throws IOException {
    return inputView.enterBonusBall();
  }

  private void buyLottoPhase() {
    agency.purchaseLotto();
    outputView.printBoughtLottoCoupons(agency);
  }
}
