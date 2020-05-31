package lotto.step4.view;

import lotto.step4.domain.Lotto;
import lotto.step4.domain.LottoNumber;
import lotto.step4.domain.LottoResult;
import lotto.step4.domain.Lottos;

import static java.util.stream.Collectors.joining;

public class ResultView {

  private static final String HEAD_FORMAT = "\n당첨 통계\n---------\n%s\n";
  private static final String BODY_FORMAT = "%d개 일치 (%d원)- %d개";
  private static final String BUYING_FORMAT = "\n수동으로 %d장, 자동으로 %d장 구매했습니다.\n%s\n\n";
  private static final String PAY_OFF_FORMAT = "총 수익률은 %.2f입니다. 결과적으로 %s입니다\n";
  private static final String NEW_LINE = "\n";
  private static final String DELIMITER = ", ";

  private static ResultView instance;

  private ResultView () { }

  public void printLottoList(Lottos lottos) {
    final String lottoList = lottos.stream()
                                   .map(ResultView::lottoToString)
                                   .collect(joining(NEW_LINE));

    System.out.printf(
      BUYING_FORMAT,
      lottos.getDirectLottosSize(),
      lottos.getAutoLottosSize(),
      lottoList
    );
  }

  public void printStat (LottoResult lottoResult) {
    System.out.printf(HEAD_FORMAT,
      lottoResult.getPrizes().stream()
                             .map(prize -> String.format(BODY_FORMAT,
                                                         prize.getRank().getSame(),
                                                         prize.getRank().getPrice(),
                                                         prize.getCount()))
                             .collect(joining(NEW_LINE))
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
                      .map(LottoNumber::getNumber)
                      .map(String::valueOf)
                      .collect(joining(DELIMITER));
    return "[" + str + "]";
  }

}
