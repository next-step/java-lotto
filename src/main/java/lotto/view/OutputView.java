package lotto.view;

import lotto.domain.LottoNumbers;
import lotto.domain.LottoRank;

import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String PURCHASE_COUNT_MESSAGE = "수동으로 %d장, 자동으로 %d개를 구매했습니다.";
    private static final String WIN_MATCH_MESSAGE = "%d개 일치 (%s원) - %d개";
    private static final String WIN_SECOND_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    private OutputView() { }

    public static void printLotteryCount(int manualCount, int allCount) {
        System.out.println();
        System.out.println(String.format(PURCHASE_COUNT_MESSAGE, manualCount, allCount - manualCount));
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

        printRank(WIN_MATCH_MESSAGE,        LottoRank.FOURTH,       chart.get(LottoRank.FOURTH));
        printRank(WIN_MATCH_MESSAGE,        LottoRank.THIRD,        chart.get(LottoRank.THIRD));
        printRank(WIN_MATCH_MESSAGE,        LottoRank.SECOND,       chart.get(LottoRank.SECOND));
        printRank(WIN_SECOND_BONUS_MESSAGE, LottoRank.SECOND_BONUS, chart.get(LottoRank.SECOND_BONUS));
        printRank(WIN_MATCH_MESSAGE,        LottoRank.FIRST,        chart.get(LottoRank.FIRST));
    }

    private static void printRank(final String message, final LottoRank rank, final Integer matchCount) {
        System.out.println(String.format(message, rank.getMatchCount(), rank.getRankPrice().toString(), matchCount));
    }

    public static void printRatio(final double ratio) {
        System.out.println("총 수익률은 " + ratio + "입니다.");
    }
}
