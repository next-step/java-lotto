package lotto;

import static util.LottoOutputView.printResultInfo;
import static util.LottoOutputView.printRevenueRate;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import util.LottoInputView;
import util.LottoOutputView;

public class LottoController {

  private static final int REVENUE_RATE_SCALE = 2;

  public void proceed() {
    PaymentAmount paymentAmount = LottoInputView.insertPaymentAmount();
    LottoList lottoList = new LottoList(paymentAmount);

    LottoOutputView.print(lottoList.toStringForPrinting());
    LottoOutputView.printPurchaseAmount(lottoList.getTotalLottoCount());
    LottoOutputView.print(lottoList.toStringForPrinting());

    Lotto winningLotto = new Lotto(LottoInputView.insertWinningLotto());

    printResultInfo();
    int totalRevenue = Arrays.stream(LottoPrize.values())
        .mapToInt(lottoPrize -> {
          int matchedLottoCount = lottoPrize.getMatchedLottoCount(winningLotto, lottoList);
          LottoOutputView.printMatchedLottoCount(lottoPrize, matchedLottoCount);
          return lottoPrize.getRevenue(matchedLottoCount);
        })
        .sum();

    BigDecimal revenueRate = BigDecimal.valueOf(totalRevenue)
        .divide(
            BigDecimal.valueOf(lottoList.getTotalPurchaseAmount()),
            REVENUE_RATE_SCALE,
            RoundingMode.HALF_UP
        );

    printRevenueRate(revenueRate);
  }

  public static LottoController init() {
    return new LottoController();
  }
}
