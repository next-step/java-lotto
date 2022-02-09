package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.vo.RankCounts;
import lotto.domain.dto.ResultDto;

public class PrintView {

    private final static String RANK_FAIL = "FAIL";
    private final static String RANK_SECOND = "SECOND";
    private final static String FAIL_MATCH_COUNT = "0-2개";
    private final static String BONUS_BALL_MATCH = "보너스 볼 일치";

    private PrintView() {
    }

    public static void printNumberOfLotto(final int size) {
        System.out.printf("%d개를 구매했습니다.\n", size);
    }

    public static void printLottoNumber(final Lottos lottos) {
        lottos.get().forEach(lotto -> System.out.println(lotto.get()));
    }

    public static void printResult(final ResultDto resultDto) {
        printRankCounts(resultDto.getNumberOfRanks());
        printProfitRate(resultDto.getProfitRate());
    }

    private static void printRankCounts(RankCounts rankCounts) {
        StringBuilder result = new StringBuilder();

        rankCounts.get().forEach((rank, count) -> {
            result.append(String.format("%s 일치, ",
                    getMatchResultString(rank.name(), rank.getMatchCount())));
            result.append(String.format("(%d원) - %d개%n", rank.getAmount(), count));
        });

        System.out.print(result);
    }

    private static String getMatchResultString(final String rank, final int count) {
        if (rank.equals(RANK_FAIL)) {
            return FAIL_MATCH_COUNT;
        }

        StringBuilder matchString = new StringBuilder();
        matchString.append(String.format("%d개", count));
        if (rank.equals(RANK_SECOND)) {
            matchString.append(BONUS_BALL_MATCH);
        }

        return matchString.toString();
    }

    private static void printProfitRate(final double profitRatio) {
        System.out.printf("총 수익률은 %.2f 입니다. (기준:1)\n", profitRatio);
    }
}
