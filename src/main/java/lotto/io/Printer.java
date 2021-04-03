package lotto.io;

import static lotto.domain.Rank.NONE;

import java.util.stream.Collectors;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.domain.WinningStatistics;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoCount;
import lotto.domain.lotto.LottoNumber;
import lotto.domain.lotto.LottoNumbers;
import lotto.domain.lotto.Lottos;

public final class Printer {

  public static final int CRITERION = 1;
  private static final String LOTTO_NUMBER_DELIMITER = ", ";
  private static final String COMMA_DELIMITER = ", ";
  private static final String MANUALLY = "수동으로 ";
  private static final String AUTOMATICALLY = "자동으로 ";
  private static final String LOTTO_UNIT = "장";
  private static final String BOUGHT = "을 구매했습니다.";
  private static final String INPUT_MANUAL_NUMBER = "수동으로 구매할 로또 번호를 입력해주세요.";

  private Printer() {}

  public static void printLottoCount(Lottos userLottos, LottoCount manualCount) {
    LottoCount lottoCount = new LottoCount(userLottos.count());
    LottoCount automaticCount = lottoCount.subtract(manualCount);

    StringBuilder lottoCountBuilder = new StringBuilder();

    if (manualCount.isBiggerThan(LottoCount.ZERO)) {
      lottoCountBuilder.append(MANUALLY).append(manualCount.getLottoCount()).append(LOTTO_UNIT);
    }
    if (manualCount.isBiggerThan(LottoCount.ZERO) && automaticCount.toInteger() != 0) {
      lottoCountBuilder.append(COMMA_DELIMITER);
    }
    if (automaticCount.isBiggerThan(LottoCount.ZERO)) {
      lottoCountBuilder.append(AUTOMATICALLY).append(automaticCount.getLottoCount()).append(LOTTO_UNIT);
    }
    lottoCountBuilder.append(BOUGHT);
    System.out.println(lottoCountBuilder.toString());
  }

  public static void printLottos(Lottos userLottos) {
    for (Lotto lotto : userLottos.getLottos()) {
      printLottoNumbers(lotto.getLottoNumbers());
    }
    printBlankLine();
  }

  private static void printLottoNumbers(LottoNumbers lottoNumbers) {
    System.out.println(lottoNumbers.getSortedLottoNumbers().stream()
        .map(LottoNumber::toStringValue)
        .collect(Collectors.joining(LOTTO_NUMBER_DELIMITER, "[", "]")));
  }

  public static void printRank(WinningStatistics winningStatistics) {
    System.out.println("당첨 통계");
    System.out.println("----------");

    for (Rank rank : Rank.values()) {
      printMessageAndCountOfRank(winningStatistics, rank);
    }
  }

  public static void printResult(WinningStatistics winningStatistics, Money userMoney) {
    long winnings = winningStatistics.totalMoney().toInteger();
    double yield = (double) winnings / userMoney.toInteger();

    System.out.println("당첨금: " + winnings + "원");
    System.out.printf("총 수익률은 %.2f입니다.", yield);
    if (yield < CRITERION) {
      System.out.print("(기준이 " + CRITERION + "이기 때문에 결과적으로 손해라는 의미임)");
    }
    printBlankLine();
  }

  private static void printMessageAndCountOfRank(WinningStatistics winningStatistics, Rank rank) {
    if (!NONE.equals(rank)) {
      printRankMessage(winningStatistics, rank);
    }
  }

  private static void printRankMessage(WinningStatistics winningStatistics, Rank rank) {
    StringBuilder rankMessageBuilder = new StringBuilder().append(rank.getMatchCount()).append("개 일치");
    if (rank.isBonusNumberMatch()) {
      rankMessageBuilder.append(", 보너스 볼 일치");
    }
    rankMessageBuilder.append("(").append(rank.getMoney().toInteger()).append("원) - ")
        .append(winningStatistics.countOf(rank)).append("개");
    System.out.println(rankMessageBuilder.toString());
  }

  public static void printBlankLine() {
    System.out.println();
  }

  public static void printInputManualNumber() {
    System.out.println(INPUT_MANUAL_NUMBER);
  }
}
