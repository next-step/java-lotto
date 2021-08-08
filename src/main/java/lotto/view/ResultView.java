package lotto.view;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import lotto.domain.LottoResult;
import lotto.message.Message;
import lotto.service.Rank;

public class ResultView {

  private static final String PROFIT_RATE_FORMAT = "#.##";

  public static void drawCountOfBuyLotteries(final int count) {
    System.out.println(count + Message.MSG_BUY_LOTTO_COUNT);
  }

  public static void drawResult(LottoResult matchResult, final double gradingScore) {
    System.out.println(
        "\n" +
            Message.MSG_WINNING_STATISTICS_WORD +
            "\n" +
            "------------------------------------");

    for (Rank rank : matchResult.getCategoriesRank().keySet()) {
      System.out.println(rank.getCountOfMatch() + "개 일치 ("
          + Rank.matchRank(rank.getCountOfMatch()).getWinningMoney()
          + "원) - "
          + matchResult.getCategoriesRank().get(rank).size()
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
