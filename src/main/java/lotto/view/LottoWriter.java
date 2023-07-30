package lotto.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.BoughtLottos;
import lotto.domain.Lotto;
import lotto.domain.WinningCriteria;

public class LottoWriter {

    private static final String DELIMITER = ", ";

    public void printBoughtLottos(final BoughtLottos boughtLottos) {
        System.out.println(boughtLottos.getCount() + "개를 구매했습니다.");

        String collect = boughtLottos.getLottos()
                .stream()
                .map(this::formatLottos)
                .collect(Collectors.joining("\n"));

        System.out.println(collect);
    }

    private String formatLottos(final Lotto lotto) {
        String result = "[";

        result += lotto.getBalls()
                .stream()
                .map(b -> String.valueOf(b.getValue()))
                .collect(Collectors.joining(DELIMITER));

        return result + "]";
    }

    public void printLottoStatistics(final WinningStatistics winningStatistics) {
        System.out.println("당첨 통계");
        System.out.println("-----------");

        List<WinningCriteria> criterias = Arrays.asList(WinningCriteria.values());
        Collections.reverse(criterias);
        printStatistics(winningStatistics, criterias);

        final double earningRate = Math.floor(winningStatistics.getEarningRate() * 100) / 100;
        printEarningRate(earningRate);
    }

    private void printEarningRate(final double earningRate) {
        System.out.printf("총 수익률은 %.2f 입니다.", earningRate);

        if (earningRate > 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 이득이라는 의미임)");
            return;
        }
        if (earningRate < 1) {
            System.out.println("(기준이 1이기 때문에 결과적으로 손해라는 의미임)");
            return;
        }
        System.out.println("(기준이 1이기 때문에 결과적으로 본전이라는 의미임)");
    }

    private void printStatistics(WinningStatistics winningStatistics, List<WinningCriteria> criterias) {
        for (WinningCriteria criteria : criterias) {
            printEachStatistics(winningStatistics, criteria);
        }
    }

    private void printEachStatistics(final WinningStatistics winningStatistics, final WinningCriteria criteria) {
        switch (criteria) {
            case SECOND:
                printStatisticsForBonus(
                        criteria.getMatchCount(), criteria.getPrize(), winningStatistics.getRank(criteria));
                return;

            case FIRST:
            case THIRD:
            case FOURTH:
            case FIFTH:
                printStatistics(criteria.getMatchCount(), criteria.getPrize(), winningStatistics.getRank(criteria));
        }
    }

    private void printStatisticsForBonus(final int matchCount, final long prize, final int boughtCount) {
        System.out.println(matchCount + "개 일치 , 보너스 볼 일치(" + prize + "원)- " + boughtCount + "개");
    }

    private void printStatistics(final int matchCount, final long prize, final int boughtCount) {
        System.out.println(matchCount + "개 일치 (" + prize + "원)- " + boughtCount + "개");
    }
}
