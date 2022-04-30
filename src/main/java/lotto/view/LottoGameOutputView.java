package lotto.view;

import lotto.domain.LottoDrawResults;
import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoReword;

public class LottoGameOutputView {

  public static final String LOTTO_MATCH_MESSAGE = "%d 개 일치 (%d)- %d개\n";
  private static final String LOTTO_STATS_MESSAGE = "당첨 통계";
  private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f 입니다.";

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
    System.out.print(messageSb.toString());
  }

  public static void printGameResult(LottoDrawResults lottoDrawResults) {
    System.out.println(LOTTO_STATS_MESSAGE);
    System.out.println("---------");
    printGameResultByMatchCount(lottoDrawResults);
    printProfitRate(lottoDrawResults);

  }

  private static void printProfitRate(LottoDrawResults lottoDrawResults) {
    long rewordAll = lottoDrawResults.getRewordAll();
    int purchaseAmount = lottoDrawResults.getValues().size() * LottoGame.GAME_PRICE;
    System.out.printf(PROFIT_RATE_MESSAGE, (double) rewordAll / purchaseAmount);
  }

  private static void printGameResultByMatchCount(LottoDrawResults lottoDrawResults) {
    for (int i = 3; i <= LottoGame.NUMBER_COUNT; i++) {
      LottoDrawResults result = lottoDrawResults.getDrawResultsByMatchCount(i);
      System.out.printf(LOTTO_MATCH_MESSAGE, i, LottoReword.getWinMoney(i),
          result.getValues().size());
    }
  }
}
