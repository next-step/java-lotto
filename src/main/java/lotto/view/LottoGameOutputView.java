package lotto.view;

import lotto.domain.LottoGame;
import lotto.domain.LottoGames;
import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.LottoReword;
import lotto.domain.LottoRewords;
import lotto.domain.ProfitRate;

public class LottoGameOutputView {

  public static final String LOTTO_MATCH_MESSAGE = "%d 개 일치 (%d)- %d개\n";
  public static final String LOTTO_MATCH_WITH_BONUS_MESSAGE = "%d 개 일치, 보너스 볼 일치(%d)- %d개\n";
  private static final String LOTTO_STATS_MESSAGE = "당첨 통계";
  private static final String PROFIT_RATE_MESSAGE = "총 수익률은 %.2f 입니다.";
  private static final String LOTTO_PURCHASE_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.\n";


  private LottoGameOutputView() {
  }


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

  public static void printGameResult(LottoRewords lottoRewords) {
    System.out.println(LOTTO_STATS_MESSAGE);
    System.out.println("---------");
    printGameResultByRank(lottoRewords);
    printProfitRate(lottoRewords);

  }

  private static void printGameResultByRank(LottoRewords lottoRewords) {
    for (int i = LottoReword.values().length - 2; i >= 0; i--) {
      LottoReword targetReword = LottoReword.values()[i];
      LottoRewords rewords = lottoRewords.getRewords(targetReword);
      printReword(targetReword, rewords);
    }
  }

  private static void printProfitRate(LottoRewords lottoRewords) {
    ProfitRate profitRate = new ProfitRate(lottoRewords.getSize(), lottoRewords.getRewordSum());
    System.out.printf(PROFIT_RATE_MESSAGE, profitRate.getValue());
  }

  private static void printReword(LottoReword targetReword, LottoRewords rewords) {
    if (targetReword.isBonusMatch()) {
      printGameResultWithBonus(targetReword, rewords);
      return;
    }
    printGameResultMessage(targetReword, rewords);
  }

  private static void printGameResultMessage(LottoReword targetReword, LottoRewords rewords) {
    System.out.printf(LOTTO_MATCH_MESSAGE, targetReword.getMatchCount(), targetReword.getMoney(),
        rewords.getSize());
  }

  private static void printGameResultWithBonus(LottoReword targetReword, LottoRewords rewords) {
    System.out.printf(LOTTO_MATCH_WITH_BONUS_MESSAGE, targetReword.getMatchCount(),
        targetReword.getMoney(), rewords.getSize());
  }

  public static void printLottoPurchase(int autoAmount, int manualAmount) {
    System.out.printf(LOTTO_PURCHASE_MESSAGE, manualAmount, autoAmount);
  }
}
