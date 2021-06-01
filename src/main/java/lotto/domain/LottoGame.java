package lotto.domain;

import lotto.input.InputView;
import lotto.input.PurchaseAmountQuantity;
import lotto.input.WinningNumber;
import lotto.output.ResultView;

public final class LottoGame {

  private final InputView inputView;
  private final LottoSeller lottoSeller;
  private final ResultView resultView;

  public LottoGame(InputView inputView, LottoSeller lottoSeller, ResultView resultView) {
    this.inputView = inputView;
    this.lottoSeller = lottoSeller;
    this.resultView = resultView;
  }

  public void start() {
    PurchaseAmountQuantity purchaseAmountQuantity = inputView.input();

    LottoBucket lottoBucket = lottoSeller.getLottoBucketBy(purchaseAmountQuantity);
    WinningNumber winningNumber = inputView.getWinningNumber();

    resultView.printBy(purchaseAmountQuantity, lottoBucket, winningNumber);
  }
}
