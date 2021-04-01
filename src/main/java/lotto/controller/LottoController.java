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

  public LottoController() throws IOException {
    LottoAgency agency = createLottoAgency();
    buyLottoPhase(agency);
    Lotto winningNumbers = getWinLottoNumbers();
    lottoResult(winningNumbers, agency);
  }

  public static void startLottoGame() throws IOException {
    new LottoController();
  }

  private void lottoResult(final Lotto winningNumbers, final LottoAgency agency) throws IOException {
    Number bonusBall = getBonusBall();
    new OutputView().printResult(agency.getLottoResult(winningNumbers, bonusBall));
  }

  private LottoAgency createLottoAgency() throws IOException {
    return new LottoAgency(getSeedMoney());
  }

  private Lotto getWinLottoNumbers() throws IOException {
    return new InputView(reader).enterWinnerNumbers();
  }

  private Money getSeedMoney() throws IOException {
    return new InputView(reader).howManyBuyLottoCoupon();
  }

  private Number getBonusBall() throws IOException {
    return new InputView(reader).enterBonusBall();
  }

  private void buyLottoPhase(final LottoAgency agency) {
    agency.purchaseLotto();
    new OutputView().printBoughtLottoCoupons(agency);
  }
}
