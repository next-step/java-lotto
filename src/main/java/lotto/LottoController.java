package lotto;

import static util.LottoOutputView.print;
import static util.LottoOutputView.printPurchaseAmount;
import static util.LottoOutputView.printResultInfo;
import static util.LottoOutputView.printRevenueRate;

import util.LottoInputView;

public class LottoController {


  public void proceed() {
    PaymentAmount paymentAmount = LottoInputView.insertPaymentAmount();
    LottoList lottoList = new LottoList(paymentAmount);

    print(lottoList.toStringForPrinting());
    printPurchaseAmount(lottoList.getTotalLottoCount());
    print(lottoList.toStringForPrinting());

    Lotto winning = new Lotto(LottoInputView.insertWinningLotto());
    LottoNumber bonus = new LottoNumber(LottoInputView.insertBonusNumber());

    WinningLotto winningLotto = new WinningLotto(winning, bonus);
    Result result = lottoList.drawing(winningLotto);

    printResultInfo();

    int totalRevenue = 0;
    for (LottoPrize lottoPrize : LottoPrize.values()) {
      if (lottoPrize.equals(LottoPrize.NONE)) {
        continue;
      }
      int matchedLottoCount = result.getMatchedLottoCount(lottoPrize);
      totalRevenue += lottoPrize.getRevenue(matchedLottoCount);
      print(result.buildResultMessage(lottoPrize));
    }

    printRevenueRate(lottoList.getRevenueRate(totalRevenue));
  }

  public static LottoController init() {
    return new LottoController();
  }
}
