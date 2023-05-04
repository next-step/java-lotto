package lotto.view;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.game.LottoGameStatistics;
import lotto.domain.game.LottoGameType;
import lotto.domain.game.LottoWinType;
import lotto.domain.round.LottoRound;
import lotto.domain.round.LottoRoundResult;

public class ResultView {

  public void displayStatistics (LottoGameStatistics statistics) {
    Map<LottoWinType, List<LottoRoundResult>> winTypeMap = statistics.getWinTypeMap();
    System.out.println("\n당첨 통계\n---------");
    for (LottoWinType winType : LottoWinType.getWithPrizedWinType()) {
      List<LottoRoundResult> lottoRoundResults = winTypeMap.getOrDefault(winType, Collections.emptyList());
      System.out.printf(getDisplayMsgByWinType(winType), winType.getMatchingNumberCnt(), winType.getPrize(), lottoRoundResults.size());
    }

    System.out.printf("총 수익률은 %s", statistics.getTotalRateOfReturn());
  }

  private static String getDisplayMsgByWinType (LottoWinType winType) {
    if (winType.isBonusNumberRequired()) {
      return "%d개 일치, 보너스볼 일치 (%d원) - %d개\n";
    }

    return "%d개 일치 (%d원) - %d개\n";
  }

  public void showLottoRounds (List<LottoRound> lottoRounds) {
    Map<LottoGameType, List<LottoRound>> gameTypeRounds = lottoRounds.stream()
        .collect(Collectors.groupingBy(LottoRound::getGameType));

    System.out.printf("\n%s 를 구매했습니다.\n", getRoundCountForGameType(gameTypeRounds));
    System.out.println(
        lottoRounds.stream()
            .map(LottoRound::getRoundNumbers)
            .map(Object::toString)
            .collect(Collectors.joining("\n"))
    );
  }

  private String getRoundCountForGameType(Map<LottoGameType, List<LottoRound>> gameTypeRounds) {
    return gameTypeRounds.entrySet().stream()
        .map(entry -> String.format(String.format("%s으로 %d개", entry.getKey().getName(), entry.getValue().size())))
        .collect(Collectors.joining(","));
  }
}
