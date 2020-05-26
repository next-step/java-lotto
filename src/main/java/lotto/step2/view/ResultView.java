package lotto.step2.view;

import lotto.step2.domain.Lotto;
import lotto.step2.domain.LottoGame;
import lotto.step2.domain.Lottos;
import lotto.step2.domain.Rank;

import static java.util.stream.Collectors.joining;

public class ResultView {

  private static final String HEAD_FORMAT = "\n당첨 통계\n---------\n%s\n";
  private static final String BODY_FORMAT = "%d개 일치 (%d원)- %d개";
  private static final String BUYING_FORMAT = "%d개를 구매했습니다.\n%s\n\n";
  private static final String PAY_OFF_FORMAT = "총 수익률은 %.2f입니다. 결과적으로 %s입니다\n";

  private static ResultView instance;

  private ResultView () { }

  public void printLottoList(Lottos lottos) {
    final long lottoCount = lottos.stream().count();
    final String lottoList = lottos.stream()
                                      .map(ResultView::lottoToString)
                                      .collect(joining("\n"));

    System.out.printf(BUYING_FORMAT, lottoCount, lottoList);
  }

  public void printStat (LottoGame lottoGame) {
    System.out.printf(HEAD_FORMAT,
      Rank.stream()
          .map(rank -> String.format(BODY_FORMAT,
                                     rank.getSame(),
                                     rank.getPrice(),
                                     lottoGame.getWinningCount(rank)))
          .collect(joining("\n"))
    );
  }



  public void printPayoffRatio (double payoffRatio) {
    System.out.printf(
      PAY_OFF_FORMAT,
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
    String str = lotto.stream()
                      .map(String::valueOf)
                      .collect(joining(", "));
    return "[" + str + "]";
  }

}
