package lotto;

import java.math.BigDecimal;
import util.LottoInputView;
import util.LottoOutputView;

public class LottoController {

  private static final int LOTTO_PRICE = 1000;

  public void proceed() {
    int paymentAmount = LottoInputView.insertPaymentAmount();
    int purchaseAmount = getLottoAmount(paymentAmount);
    LottoList lottoList = new LottoList(purchaseAmount);
    LottoOutputView.print(lottoList.toStringForPrinting());
    LottoOutputView.printPurchaseAmount(purchaseAmount);
    LottoOutputView.print(lottoList.toStringForPrinting());

    Lotto winningLotto = new Lotto(LottoInputView.insertWinningLotto());
    BigDecimal revenueRate = lottoList.calculateRevenueWithWinningNumber(winningLotto);

    LottoOutputView.printRevenue(revenueRate);
  }

  private int getLottoAmount(int money) {
    return money / LOTTO_PRICE;
  }

  public static LottoController init() {
    return new LottoController();
  }
}
