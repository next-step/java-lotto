package lotto;

import java.math.BigDecimal;
import util.LottoInputView;
import util.LottoOutputView;

public class LottoController {

  public void proceed() {
    PaymentAmount paymentAmount = LottoInputView.insertPaymentAmount();
    LottoList lottoList = new LottoList(paymentAmount);

    LottoOutputView.print(lottoList.toStringForPrinting());
    LottoOutputView.printPurchaseAmount(lottoList.getTotalLottoCount());
    LottoOutputView.print(lottoList.toStringForPrinting());

    Lotto winningLotto = new Lotto(LottoInputView.insertWinningLotto());
    BigDecimal revenueRate = lottoList.calculateRevenueWithWinningNumber(winningLotto);

    LottoOutputView.printRevenue(revenueRate);
  }

  public static LottoController init() {
    return new LottoController();
  }
}
