package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.game.LottoGameStatistics;
import lotto.domain.game.LottoWinType;
import lotto.domain.round.LottoRound;
import lotto.domain.round.LottoRoundResult;

public class ResultView {

  public static void displayStatistics (LottoGameStatistics statistics) {
    Map<LottoWinType, List<LottoRoundResult>> winTypeMap = statistics.getWinTypeMap();
    System.out.println("\n당첨 통계\n---------");
    for (LottoWinType value : LottoWinType.values()) {
      List<LottoRoundResult> lottoRoundResults = winTypeMap.getOrDefault(value, Collections.emptyList());
      System.out.printf("%d개 일치 (%d원) - %d개\n", value.getMatchingNumberCnt(), value.getPrize(), lottoRoundResults.size());
    }

    System.out.printf("총 수익률은 %s", statistics.getTotalRateOfReturn());
  }

  public static void showLottoRounds (List<LottoRound> lottoRounds) {
    System.out.printf("%d개를 구매했습니다.\n", lottoRounds.size());
    System.out.println(
        lottoRounds.stream()
            .map(LottoRound::getRoundNumbers)
            .map(Object::toString)
            .collect(Collectors.joining("\n"))
    );
  }
}
