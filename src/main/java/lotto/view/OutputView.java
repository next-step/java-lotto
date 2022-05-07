package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.Arrays;
import java.util.Comparator;

public class OutputView {
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String SEPARATOR = "---------";

    public static void outputLottoNumbers(Lottos lottos) {
        System.out.printf("%s개를 구매했습니다.\n", lottos.length());
        lottos.print();
        System.out.println();
    }

    public static void outputWinningStatistics(Lottos lottos, LottoNumbers winningLottoNumbers, LottoNumber bonusBall) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(SEPARATOR);

        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.comparingInt(Rank::getWinningMoney))
                .forEach(rank -> {
                    int countOfMatchNumber = lottos.getRankCount(winningLottoNumbers, bonusBall, rank);

                    System.out.printf("%s개 일치 (%s원)- %s개\n", rank.getCountOfMatch(), rank.getWinningMoney(), countOfMatchNumber);
                });
    }

    public static void outputRevenueRate(Lottos lottos, LottoNumbers winningLottoNumbers, LottoNumber bonusBall) {
        double revenueRate = lottos.getRevenueRate(winningLottoNumbers, bonusBall);
        System.out.printf("총 수익률은 %.2f입니다.", revenueRate);
    }
}

