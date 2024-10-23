package lotto.ui;

import lotto.domain.LottoWinningCountDecision;
import lotto.domain.OneTimeRoundLottoNumberList;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PrintView {

    public static void printLottoTryCount(int lottoTryCount) {
        System.out.println(lottoTryCount + "개를 구매했습니다.");

    }

    public static void printLottoList(List<OneTimeRoundLottoNumberList> lottoNumberList) {
        for (OneTimeRoundLottoNumberList oneTimeRoundLottoNumberList : lottoNumberList) {
            System.out.println("[" + oneTimeRoundLottoNumberList.convertLottoNumberList().stream().
                    map(String::valueOf)
                    .collect(Collectors.joining(", ")) + "]");
        }
    }

    public static void printWinningStatisticsPreview() {
        System.out.println("당첨 통계");
        System.out.println("---------");
    }

    public static void printWinningCount(Map<Integer, Integer> winningLottoCountMap) {
        for (int rank : winningLottoCountMap.keySet()) {
            System.out.printf("%d개 일치 (%d원)- %d개\n", LottoWinningCountDecision.convertRankToMatchingNumber(rank),
                    LottoWinningCountDecision.convertMatchingRankToAmount(rank), winningLottoCountMap.get(rank));
        }
    }

    public static void printMargin(double profitMargin) {
        System.out.println("총 수익률은 " + profitMargin + "입니다.");

    }

}
