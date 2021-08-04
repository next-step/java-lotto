package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.service.Rank;

public class ResultView {

  public ResultView(Map<Integer, List<Lotto>> matchResult, String profitRate) {

    System.out.println("당첨 통계\n"
        + "---------");

    for (Integer ratingNumber : matchResult.keySet()) {
      System.out.println(ratingNumber + "개 일치 ("
          + Rank.matchRank(ratingNumber).getWinningMoney()
          + ") - "
          + matchResult.get(ratingNumber).size()
          + "개");
    }

    System.out.println("총 수익률은 "+ profitRate +"입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
  }
}
