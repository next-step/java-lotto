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

  public static void drawCountOfBuyLotteries(final int count) {
    System.out.println(count + Message.MSG_BUY_LOTTO_COUNT);
  }

  public static void drawResult(final Map<Rank, List<Lotto>> matchResult, final double gradingScore) {
    System.out.println(
        "\n" +
            Message.MSG_WINNING_STATISTICS_WORD +
            "\n" +
            "------------------------------------");

    for (Rank ratingNumber : matchResult.keySet()) {
      System.out.println(ratingNumber + "개 일치 ("
          + Rank.matchRank(ratingNumber.getCountOfMatch()).getWinningMoney()
          + "원) - "
          + matchResult.get(ratingNumber).size()
          + "개");
    }

    System.out.println(
        Message.MSG_WINNING_PROFIT + formattingValue(gradingScore) + Message.MSG_WINNING_PROFIT_INFO);
    }

    private static String formattingValue(double profitRate){

      DecimalFormat format = new DecimalFormat(PROFIT_RATE_FORMAT);
      format.setRoundingMode(RoundingMode.DOWN);

      return format.format(profitRate);
    }
  }
