package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.message.Message;
import lotto.domain.Lotto;
import lotto.service.Rank;

public class ResultView {

  public ResultView(Map<Integer, List<Lotto>> matchResult, String profitRate) {

    System.out.println(
            "\n" +
            Message.MSG_WINNING_STATISTICS_WORD +
            "\n" +
            "------------------------------------");

    for (Integer ratingNumber : matchResult.keySet()) {
      System.out.println(ratingNumber + "개 일치 ("
          + Rank.matchRank(ratingNumber).getWinningMoney()
          + "원) - "
          + matchResult.get(ratingNumber).size()
          + "개");
    }

    System.out.println(Message.MSG_WINNING_PROFIT+ profitRate + Message.MSG_WINNING_PROFIT_INFO);
  }

  public ResultView(int count) {
    System.out.println(count + Message.MSG_BUY_LOTTO_COUNT);
  }
}
