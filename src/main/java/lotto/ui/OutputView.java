package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoAgency;
import lotto.domain.LottoCoupon;
import lotto.domain.WinningBoard;

public class OutputView {

  public static void printResult(WinningBoard totalResult) {
    System.out.println("지난 주 당첨 번호는 " );
    System.out.println(totalResult.toResultString());
    System.out.println("총 수익률은 " + totalResult.calculateEarningRate() + "입니다.");
  }

  public void printBoughtLottoCoupons(LottoAgency agency) {
    System.out.println(agency.getPurchaseQuantity() + "장을 구매하셨습니다.");
    System.out.println(printLottoCoupon(agency));
  }

  private String printLottoCoupon(LottoAgency agency) {
    StringBuilder sb = new StringBuilder();
    LottoCoupon coupon = agency.getCoupon();

    for(Lotto lotto : coupon.getLottoCoupon()) {
      sb.append("[")
          .append(lotto.toString())
          .append("]")
          .append("\n");
    }

    return sb.toString();
  }
}
