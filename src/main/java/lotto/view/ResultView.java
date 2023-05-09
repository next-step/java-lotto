package lotto.view;

import lotto.domain.Lotto;
import lotto.utility.RewardTable;

import java.util.List;
import java.util.Map;

public class ResultView {
  public static void showMyLotto(List<Lotto> lottoBundle) {
    System.out.println(lottoBundle.size() + "개를 구매하셨습니다.");

    for (Lotto lotto : lottoBundle) {
      System.out.println(lotto.getCheckedNumbers());
    }
  }

  public static void showStatistic(Map<Integer, Integer> map) {
    System.out.println("당첨 통계\n---------");

    for(RewardTable rank : RewardTable.values()) {
      System.out.printf("%s(%d원)- %d개\n", rank.getMatchInfo(), rank.amountOfReward(), map.getOrDefault(rank.getMatchNumber(), 0));
    }
  }

  public static void showRoi(double result) {
    String benefitWord = "손해";

    if (result > 0) {
      benefitWord = "이득이";
    }

    System.out.printf("총 수익률은 %.2f 입니다.(기준이 1이기 때문에 결과적으로 %s라는 의미임)", result, benefitWord);
  }
}
