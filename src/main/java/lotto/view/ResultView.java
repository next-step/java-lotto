package lotto.view;

import lotto.domain.*;

import java.util.Map;

public class ResultView {
  public static void lottoCount(PositiveNumber manualCount, PositiveNumber randomCount) {
    System.out.printf("수동으로 %s장, 자동으로 %s장을 구매했습니다.%n", manualCount, randomCount);
  }

  public static void lottoList(Lottos lottos) {
    for (Lotto lotto : lottos) {
      System.out.println(lottoToString(lotto));
    }
    System.out.println();
  }

  private static String lottoToString(Lotto lotto) {
    final String OPENER = "[";
    final String CLOSER = "]";
    final String CONNECTOR = ", ";

    StringBuilder sb = new StringBuilder(OPENER);
    for (LottoBall ball : lotto.lottoBalls()) {
      sb.append(ballToNumber(ball)).append(CONNECTOR);
    }

    final int STARTING_INDEX = 0;
    return sb.substring(STARTING_INDEX, sb.length() - CONNECTOR.length()).concat(CLOSER);
  }

  private static String ballToNumber(LottoBall ball) {
    return String.valueOf(ball.number());
  }

  public static void stats(Results results) {
    System.out.println("당첨 통계");
    System.out.println("---------");
    for (Map.Entry<Prize, PositiveNumber> entry : results.stats().entrySet()) {
      PrizeDto prizeDto = new PrizeDto(entry.getKey());
      System.out.printf("%d개 일치%s (%d %s) - %s개",
              prizeDto.getCondition().getMatchCount(),
              bonusBallCondition(prizeDto.getCondition().getBonusBallCondition()),
              prizeDto.getAmountDto().getValue(),
              prizeDto.getAmountDto().getCurrency(),
              entry.getValue());
    }
  }

  private static String bonusBallCondition(boolean bonusBallCondition) {
    return bonusBallCondition ? ", 보너스 볼 일치" : "";
  }

  public void printOutResultMessage(final String message) {
    System.out.println(message);
  }
}
