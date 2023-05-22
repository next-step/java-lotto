package study.lotto.view;

import study.lotto.model.Lotto;
import study.lotto.model.LottoStatistics;

public class OutputViewImpl implements OutputView {

  @Override
  public void purchaseView(Lotto lotto) {
    int count = lotto.getCount();
    System.out.println(count + "개를 구매했습니다.");
    System.out.println(lotto.list());
  }

  @Override
  public void winningStatistics(LottoStatistics lottoStatistics) {
    System.out.println("\n당첨 통계");
    System.out.println("---------\n");
    System.out.println("3개 일치 (5000원)- " + lottoStatistics.getThree() + "개");
    System.out.println("4개 일치 (50000원)- " + lottoStatistics.getFour() + "개");
    System.out.println("5개 일치 (1500000원)- " + lottoStatistics.getFive() + "개");
    System.out.println("6개 일치 (2000000000원)- " + lottoStatistics.getSix() + "개");
    System.out.println("총 수익률은 " + String.format("%.2f",lottoStatistics.getRate()) + "입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");

  }
}
