package lotto.ui;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Rank;

public class ResultView {
  private static final String PRIZE_FORMAT = "%d개 일치 (%d원)- %d개";
  private static final String SECOND_RANK_FORMAT = "%d개 일치, 보너스 볼 일치(%d원) - %d개";
  private static final String PROFIT_RATE_FORMAT = "총 수익률은 %.2f입니다.";
  private static final String LOSS_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";

  public void printLottoCount(int count) {
    System.out.println(count + "개를 구매했습니다.");
  }

  public void printLottos(List<Lotto> lottos) {
    for (Lotto lotto : lottos) {
      System.out.println(lotto.getNumbers());
    }
  }

  public void printLottoResult(LottoResult lottoResult) {
    System.out.println();
    System.out.println("당첨 통계");
    System.out.println("---------");

    printRankResult(lottoResult, Rank.FIFTH);
    printRankResult(lottoResult, Rank.FOURTH);
    printRankResult(lottoResult, Rank.THIRD);
    printSecondRankResult(lottoResult);
    printRankResult(lottoResult, Rank.FIRST);
  }

  private void printRankResult(LottoResult lottoResult, Rank rank) {
    if (rank != Rank.SECOND) {
      System.out.printf(
          PRIZE_FORMAT + "%n",
          rank.getCountOfMatch(),
          rank.getWinningMoney(),
          lottoResult.getRankCount(rank));
    }
  }

  private void printSecondRankResult(LottoResult lottoResult) {
    System.out.printf(
        SECOND_RANK_FORMAT + "%n",
        Rank.SECOND.getCountOfMatch(),
        Rank.SECOND.getWinningMoney(),
        lottoResult.getRankCount(Rank.SECOND));
  }

  public void printProfitRate(double profitRate) {
    System.out.print(String.format(PROFIT_RATE_FORMAT, profitRate));

    if (profitRate < 1.0) {
      System.out.println(LOSS_MESSAGE);
    } else {
      System.out.println();
    }
  }
}
