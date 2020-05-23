package step2.view;

import step2.domain.Lotto;
import step2.domain.LottoGame;
import step2.domain.WinningPrice;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ResultView {

  private static ResultView instance;
  private final WinningPrice[] winningPrize = {
    WinningPrice.of(5000, 3),
    WinningPrice.of(50000, 4),
    WinningPrice.of(1500000, 5),
    WinningPrice.of(2000000000, 6)
  };

  private ResultView () { }

  public void printLottos (LottoGame lottoGame) {
    System.out.println(
      lottoGame.stream()
            .map(ResultView::lottoToString)
            .collect(Collectors.joining("\n"))
      + "\n"
    );
  }

  public void printLottoCount (LottoGame lottoGame) {
    System.out.printf("%d개를 구매했습니다.\n", lottoGame.stream().count());
  }

  public void printStat (LottoGame lottoGame) {
    Arrays.stream(winningPrize)
          .forEach(winningPrice -> System.out.printf(
              "%d개 일치 (%d원)- %d개\n",
              winningPrice.getSame(),
              winningPrice.getPrice(),
              lottoGame.getWinningCount(winningPrice.getSame())
            )
          );
  }

  public void printPayoffRatio (int payoffRatio) {
    System.out.printf(
      "총 수익률은 %d입니다. 결과적으로 %s입니다\n",
      payoffRatio,
      getPayoffResult(payoffRatio)
    );
  }

  private String getPayoffResult (int payoffRatio) {
    if (payoffRatio == 1) return "본전";
    return payoffRatio < 1 ? "손해" : "이득";
  }

  public static ResultView getInstance () {
    if (instance != null) instance = new ResultView();
    return instance;
  }

  public static String lottoToString (Lotto lotto) {
    String str = lotto.stream().map(String::valueOf).collect(Collectors.joining(", "));
    return "[" + str + "]";
  }

}
