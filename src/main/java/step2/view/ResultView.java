package step2.view;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import step2.domain.Lottos;
import step2.domain.WinningPrice;

import java.util.Arrays;

public class ResultView {

  public static ResultView instance;
  public final WinningPrice[] winningPrize = {
    WinningPrice.of(5000, 3),
    WinningPrice.of(50000, 4),
    WinningPrice.of(1500000, 5),
    WinningPrice.of(2000000000, 6)
  };

  private ResultView () { }

  public void printLottos (Lottos lottos) {
    lottos.stream().forEach(System.out::println);
  }

  public void printStat (Lottos lottos) {
    Arrays.stream(winningPrize)
          .forEach(winningPrice -> System.out.printf(
              "%d개 일치 (%d원)- %d개\n",
              winningPrice.getSame(),
              winningPrice.getPrice(),
              lottos.getWinning(winningPrice.getSame()),
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

}
