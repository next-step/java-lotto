package nextstep.lotto.view;

import java.util.List;
import nextstep.lotto.domain.Lotto;
import nextstep.lotto.domain.LottoResult;
import nextstep.lotto.domain.LottoSummary;
import nextstep.lotto.domain.LottoWinCount;

public class ResultView {

  private static final String WIN_COUNT_FORMAT = "%d개 일치 (%d원)- %d개";
  private static final String RESULT_FORMAT = "총 수익률은 %s입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
  private final OutputConsumer outputConsumer;

  public ResultView(OutputConsumer outputConsumer) {
    this.outputConsumer = outputConsumer;
  }

  public void writeLottos(final List<Lotto> lottos) {
    outputConsumer.write(lottos.size() + "개를 구매했습니다.");
    for (final Lotto lotto : lottos) {
      outputConsumer.write("" + lotto);
    }
  }

  public void writeSummary(final LottoSummary summary) {
    outputConsumer.write("");
    outputConsumer.write("당첨 통계");
    outputConsumer.write("---------");
    for (LottoWinCount winResult : summary.winResults()) {
      outputConsumer.write(winCountFormat(winResult));
    }
    outputConsumer.write(String.format(RESULT_FORMAT, summary.rateOfReturn()));
  }

  private String winCountFormat(final LottoWinCount lottoWinCount) {
    final LottoResult result = lottoWinCount.result();
    return String.format(WIN_COUNT_FORMAT, result.matchCount(), result.price(),
      lottoWinCount.count());
  }
}
