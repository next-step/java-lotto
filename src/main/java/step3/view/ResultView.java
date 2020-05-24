package step3.view;

import step3.domain.Lotto;
import step3.domain.LottoGame;
import step3.domain.Rank;

import java.util.function.Function;
import java.util.stream.Collectors;

public class ResultView {

  private static ResultView instance;
  private static final String HEAD_FORMAT = "\n당첨 통계\n---------\n%s\n";
  private static final String BODY_FORMAT = "%d개 일치 (%d원)- %d개";

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
    final Function<Rank, String>
          mapper = rank -> String.format(BODY_FORMAT,
                                         rank.getSame(),
                                         rank.getPrice(),
                                         lottoGame.getRankCountOf(rank));
    final String stat = Rank.stream().map(mapper).collect(Collectors.joining("\n"));
    System.out.printf(HEAD_FORMAT, stat);
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
