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

      System.out.println(rank.getCountOfMatch() + "개 일치"
          + createResultMessageByRank(rank)
          + rank.getWinningMoney()
          + "원) - "
          + matchResult.getCategoriesRank().get(rank).size()
          + "개");
    }

    System.out.println(
        Message.MSG_WINNING_PROFIT + formattingValue(gradingScore) + getProfitResultMessage(gradingScore));
    }

  private static String createResultMessageByRank(final Rank rank) {
    String messageForm = " (";

    if(rank.equals(Rank.SECOND)){
      messageForm = ", 보너스 볼 일치 (";
    }
    return messageForm;
  }

  private static String getProfitResultMessage(double gradingScore) {
    if(gradingScore > 1){
      return Message.MSG_WINNING_PROFIT_INFO.replace("${}","이득");
    }
    return Message.MSG_WINNING_PROFIT_INFO.replace("${}","손해");
  }

  private static String formattingValue(double profitRate){

      DecimalFormat format = new DecimalFormat(PROFIT_RATE_FORMAT);
      format.setRoundingMode(RoundingMode.DOWN);

      return format.format(profitRate);
    }
  }
