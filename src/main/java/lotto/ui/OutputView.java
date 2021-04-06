package lotto.ui;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import lotto.domain.Lotto;
import lotto.domain.LottoAgency;
import lotto.domain.LottoCoupon;
import lotto.domain.LottoScoreBoard;

public class OutputView {

  public void printMatchResult(LottoScoreBoard totalResult) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    System.out.println(totalResult.toResultString());
  }

  public void printTotalEarningRate(double earningRate) {
    System.out.println("총 수익률은 " + doubleToStringFormat(earningRate) + "입니다.");
  }

  public void printBoughtLottoManualCoupons(LottoAgency agency) {
    System.out.print("수동으로 " + agency.currentBoughtCouponQuantity() + "장, ");
  }
  public void printBoughtLottoAutoCoupons(LottoAgency agency, int boughtAutoLottoQuantity) {
    System.out.println("자동으로 " + boughtAutoLottoQuantity + "장을 구매하셨습니다.");
    System.out.println(printLottoCoupon(agency));
  }

  private String doubleToStringFormat(double earningRate) {
    DecimalFormat df = new DecimalFormat("#.##");
    df.setRoundingMode(RoundingMode.DOWN);
    return df.format(earningRate);
  }

  private String printLottoCoupon(LottoAgency agency) {
    return agency.lottoCouponToString();
  }
}
