package lotto.controller;

import java.io.IOException;
import lotto.domain.Lotto;
import lotto.domain.LottoAgency;
import lotto.domain.LottoCoupon;
import lotto.domain.LottoScoreBoard;
import lotto.domain.Money;
import lotto.domain.Number;
import lotto.domain.WinningNumber;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {

  public LottoController() throws IOException {
    LottoAgency agency = createLottoAgency();
    buyLottoPhase(agency);
    lottoResult(agency);
  }

  public static void startLottoGame() throws IOException {
    new LottoController();
  }

  private void lottoResult(final LottoAgency agency) throws IOException {
    WinningNumber winningNumbers = WinningNumber
        .createWinningNumbers(getWinLottoNumbers(), getBonusBall());

    LottoScoreBoard lottoResult = agency.getLottoResult(winningNumbers);

    new OutputView().printMatchResult(lottoResult);
    new OutputView().printTotalEarningRate(lottoResult.totalEarningRate());
  }

  private LottoAgency createLottoAgency() throws IOException {
    return new LottoAgency(getSeedMoney(), getManualLottoQuantity());
  }

  private Lotto getWinLottoNumbers() throws IOException {
    return new InputView().enterWinnerNumbers();
  }

  private Money getSeedMoney() throws IOException {
    return new InputView().howManyBuyLottoCoupon();
  }

  private Number getBonusBall() throws IOException {
    return new InputView().enterBonusBall();
  }

  private LottoCoupon getManualLottoQuantity() throws IOException {
    Number number = new InputView().enterManualLottoQuantity();
    return new InputView().enterManualLottoNumbers(number);
  }

  private void buyLottoPhase(final LottoAgency agency) {
    new OutputView().printBoughtLottoManualCoupons(agency);
    int boughtAutoLottoQuantity = agency.purchaseLotto();
    new OutputView().printBoughtLottoAutoCoupons(agency, boughtAutoLottoQuantity);
  }
}
