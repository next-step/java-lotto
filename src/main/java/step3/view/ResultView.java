package step3.view;

import step3.domain.Lotto;
import step3.domain.LottoGame;
import step3.domain.Rank;

import java.util.stream.Collectors;

public class ResultView {

  private static ResultView instance;

  private ResultView () { }

  public void printLottoGame (LottoGame lottoGame) {
    System.out.printf(
      "%d개를 구매했습니다.\n%s\n\n",
      lottoGame.stream().count(),
      lottoGame.stream()
               .map(ResultView::lottoToString)
               .collect(Collectors.joining("\n"))
    );
  }

  public void printStat (LottoGame lottoGame) {
    String headFormat = "\n당첨 통계\n---------\n%s\n";
    String bodyFormat = "%d개 일치 (%d원)- %d개";
    System.out.printf(
      headFormat,
      Rank.stream()
          .map(winningPrice -> String.format(
              bodyFormat,
              winningPrice.getSame(),
              winningPrice.getPrice(),
              lottoGame.getWinningCount(winningPrice.getSame())))
          .collect(Collectors.joining("\n"))
    );
  }

  public void printPayoffRatio (double payoffRatio) {
    System.out.printf(
      "총 수익률은 %.2f입니다. 결과적으로 %s입니다\n",
      payoffRatio,
      getPayoffResult(payoffRatio)
    );
  }

  private String getPayoffResult (double payoffRatio) {
    if (payoffRatio == 1) return "본전";
    return payoffRatio < 1 ? "손해" : "이득";
  }

  public static ResultView getInstance () {
    if (instance == null) instance = new ResultView();
    return instance;
  }

  public static String lottoToString (Lotto lotto) {
    String str = lotto.stream().map(String::valueOf).collect(Collectors.joining(", "));
    return "[" + str + "]";
  }

}
