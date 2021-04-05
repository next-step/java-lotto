package lotto.ui;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import lotto.domain.Lotto;
import lotto.domain.LottoAgency;
import lotto.domain.LottoCoupon;
import lotto.domain.LottoScoreBoard;

public class OutputView {

  public void printResult(LottoScoreBoard totalResult) {
    System.out.println("지난 주 당첨 번호는 " );
    System.out.println(totalResult.toResultString());
    System.out.println("총 수익률은 " + doubleToStringFormat(totalResult) + "입니다.");
  }

  public void printBoughtLottoManualCoupons(LottoAgency agency) {
    System.out.print("수동으로 " + agency.getPurchaseQuantity() + "장, ");
  }
  public void printBoughtLottoAutoCoupons(LottoAgency agency) {
    System.out.println("자동으로 " + agency.getPurchaseQuantity() + "장을 구매하셨습니다.");
    System.out.println(printLottoCoupon(agency));
  }

  private String doubleToStringFormat(LottoScoreBoard totalResult) {
    DecimalFormat df = new DecimalFormat("#.##");
    df.setRoundingMode(RoundingMode.DOWN);
    return df.format(totalResult.getEarningRate());
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
