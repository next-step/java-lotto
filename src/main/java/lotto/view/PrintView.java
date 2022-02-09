package lotto.view;

import java.util.Map;
import lotto.domain.LottoRank;
import lotto.domain.Lottos;
import lotto.domain.dto.ResultDto;

public class PrintView {

    private PrintView() {
    }

    public static void printNumberOfLotto(final int size) {
        System.out.printf("%d개를 구매했습니다.\n", size);
    }

    public static void printLottoNumber(final Lottos lottos) {
        lottos.get().forEach(lotto -> System.out.println(lotto.get()));
    }

    public static void printResult(final ResultDto resultDto) {
        printRankCounts(resultDto.getMatchCount(), resultDto.getAmounts());
        printProfitRate(resultDto.getProfitRate());
    }

    private static void printRankCounts(final Map<String, Integer> matchCount, final Map<String, Integer> amounts) {
        StringBuilder result = new StringBuilder();

        matchCount.forEach((rank, count) -> {
            result.append(String.format("%s 일치, ", getMatchResultString(rank, count)));
            result.append(String.format("(%d원) - %d개%n", amounts.get(rank), count));
        });

        System.out.print(result);
    }

    private static String getMatchResultString(final String rank, final int count) {
        if(rank.equals(LottoRank.FAIL.name())){
            return "0-2개";
        }

        StringBuilder matchString = new StringBuilder();
        matchString.append(String.format("%d개", count));
        if (rank.equals(LottoRank.SECOND.name())) {
            matchString.append("보너스 볼 일치");
        }

        return matchString.toString();
    }

    private static void printProfitRate(final double profitRatio) {
        System.out.printf("총 수익률은 %.2f 입니다. (기준:1)\n", profitRatio);
    }
}
