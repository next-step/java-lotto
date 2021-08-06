package lotto.view;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.message.Message;
import lotto.service.Rank;

public class ResultView {

  private static final String PROFIT_RATE_FORMAT = "#.##";

  public ResultView(Map<Integer, List<Lotto>> matchResult, double profitRate) {

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

    System.out.println(Message.MSG_WINNING_PROFIT+ formattingValue(profitRate) + Message.MSG_WINNING_PROFIT_INFO);
  }

  public ResultView(int count) {
    System.out.println(count + Message.MSG_BUY_LOTTO_COUNT);
  }

  private String formattingValue(double profitRate) {

    DecimalFormat format = new DecimalFormat(PROFIT_RATE_FORMAT);
    format.setRoundingMode(RoundingMode.DOWN);

    return format.format(profitRate);
  }
}
