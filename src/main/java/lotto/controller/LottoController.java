package lotto.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

  private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

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
    return new InputView(reader).enterWinnerNumbers();
  }

  private Money getSeedMoney() throws IOException {
    return new InputView(reader).howManyBuyLottoCoupon();
  }

  private Number getBonusBall() throws IOException {
    return new InputView(reader).enterBonusBall();
  }

  private LottoCoupon getManualLottoQuantity() throws IOException {
    Number number = new InputView(reader).enterManualLottoQuantity();
    return new InputView(reader).enterManualLottoNumbers(number);
  }

  private void buyLottoPhase(final LottoAgency agency) throws IOException {
    new OutputView().printBoughtLottoManualCoupons(agency);
    int boughtAutoLottoQuantity = agency.purchaseLotto();
    new OutputView().printBoughtLottoAutoCoupons(agency, boughtAutoLottoQuantity);
  }
}
