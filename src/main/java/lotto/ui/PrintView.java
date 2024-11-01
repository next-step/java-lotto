package lotto.ui;



import lotto.LottoRank;
import lotto.LottoWinningCountDecision;
import lotto.ResultText;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;



public class PrintView {

    public static void printLottoTryCount(int lottoTryCount) {
        System.out.println(lottoTryCount + "개를 구매했습니다.");

    }

    public static void printLottoList(List<List<Integer>> lottoNumberList) {
        for (List<Integer> LottoNumbers : lottoNumberList) {
            System.out.println("[" + LottoNumbers.stream().
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
            System.out.printf(ResultText.convertRankToText(rank), LottoRank.convertRankToMatchingCount(rank),
                    LottoWinningCountDecision.convertMatchingRankToAmount(rank), winningLottoCountMap.get(rank));
        }
    }

    public static void printMargin(double marginAmount) {
        System.out.println("총 수익률은 " + marginAmount + "입니다.");

    }

}
