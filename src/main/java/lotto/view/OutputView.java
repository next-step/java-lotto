package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String WIN_MATCH_MESSAGE = "%d개 일치 (%s원) - %d개";

    private OutputView() { }

    public static void printLotteryCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLotteries(final List<LottoNumbers> lottoNumbers) {
        for (LottoNumbers numbers : lottoNumbers) {
            System.out.println(numbers);
        }
    }

    public static void printLottoResult(final Map<LottoRank, Integer> chart) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---------");

        printRank(LottoRank.FOURTH, chart.get(LottoRank.FOURTH));
        printRank(LottoRank.THIRD, chart.get(LottoRank.THIRD));
        printRank(LottoRank.SECOND, chart.get(LottoRank.SECOND));
        printRank(LottoRank.FIRST, chart.get(LottoRank.FIRST));
    }

    private static void printRank(final LottoRank rank, final Integer matchCount) {
        System.out.println(String.format(WIN_MATCH_MESSAGE, rank.getMatchCount()
                                                          , rank.getRankPrice().toString()
                                                          , matchCount));
    }

    public static void printRatio(final double ratio) {
        System.out.println("총 수익률은 " + ratio + "입니다.");
    }
}
