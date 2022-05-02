package lotto.view;

import lotto.domain.LottoDrawResults;
import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoReword;
import lotto.domain.ProfitRate;

public class LottoGameOutputView {

  public static final String LOTTO_MATCH_MESSAGE = "%d 개 일치 (%d)- %d개\n";
  public static final String LOTTO_MATCH_WITH_BONUS_MESSAGE = "%d 개 일치, 보너스 볼 일치(%d)- %d개\n";
  private static final String LOTTO_STATS_MESSAGE = "당첨 통계";
  private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f 입니다.";
  private static final int MATCH_COUNT_PRINT_BONUS = 5;

  public static void printLottoNumbers(LottoGames lottoGames) {
    for (LottoGame lottoGame : lottoGames.getValues()) {
      System.out.print("[");
      printLottoGame(lottoGame);
      System.out.println("]");
    }
    System.out.println("");
  }

  private static void printLottoGame(LottoGame lottoGame) {
    LottoNumbers lottoNumbers = lottoGame.getLottoNumbers();
    StringBuilder messageSb = new StringBuilder();
    for (LottoNumber lottoNumber : lottoNumbers.getValues()) {
      messageSb.append(lottoNumber.getValue() + ",");
    }
    messageSb.delete(messageSb.length() - 1, messageSb.length());
    System.out.print(messageSb);
  }

  public static void printGameResult(LottoDrawResults lottoDrawResults) {
    System.out.println(LOTTO_STATS_MESSAGE);
    System.out.println("---------");
    printGameResultByMatchCount(lottoDrawResults);
    printProfitRate(lottoDrawResults);

  }

  private static void printProfitRate(LottoDrawResults lottoDrawResults) {
    long rewordAll = lottoDrawResults.getRewordAll();
    int gameCount = lottoDrawResults.getValues().size();
    ProfitRate profitRate = new ProfitRate(gameCount, rewordAll);
    System.out.printf(PROFIT_RATE_MESSAGE, profitRate.getValue());
  }

  private static void printGameResultByMatchCount(LottoDrawResults lottoDrawResults) {
    for (int i = 3; i <= LottoGame.NUMBER_COUNT; i++) {
      LottoDrawResults result = lottoDrawResults.getDrawResultsByMatchCount(i);
      printGameResult(i, result);
    }
  }

  private static void printGameResult(int matchCount, LottoDrawResults result) {
    if (matchCount == MATCH_COUNT_PRINT_BONUS) {
      printGameResultWithBonus(MATCH_COUNT_PRINT_BONUS, result);
      return;
    }
    printGameResultMessage(matchCount, result);
  }

  private static void printGameResultMessage(int matchCount, LottoDrawResults result) {
    System.out.printf(LOTTO_MATCH_MESSAGE, matchCount, LottoReword.getWinMoney(matchCount, false),
        result.getValues().size());
  }

  private static void printGameResultWithBonus(int matchCount, LottoDrawResults result) {
    printGameResultMessage(matchCount, result.filterBonusBall(false));
    printGameResultMessageWithBonus(matchCount, result.filterBonusBall(true));
  }

  private static void printGameResultMessageWithBonus(int matchCount,
      LottoDrawResults matchResult) {
    System.out.printf(LOTTO_MATCH_WITH_BONUS_MESSAGE, matchCount,
        LottoReword.getWinMoney(matchCount, true),
        matchResult.getValues().size());
  }
}
