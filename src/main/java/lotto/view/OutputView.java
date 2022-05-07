package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.Lottos;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Consumer;

public class OutputView {
    private static final String WINNING_STATISTICS = "당첨 통계";
    private static final String SEPARATOR = "---------";

    public static void outputLottoNumbers(Lottos lottos) {
        System.out.printf("%s개를 구매했습니다.\n", lottos.length());
        lottos.print();
        System.out.println();
    }

    public static void outputWinningStatistics(Lottos lottos, WinningLotto winningLotto) {
        System.out.println(WINNING_STATISTICS);
        System.out.println(SEPARATOR);

        Arrays.stream(Rank.values())
                .filter(rank -> !rank.isMiss())
                .sorted(Comparator.comparingInt(Rank::getWinningMoney))
                .forEach(outputStatistics(lottos, winningLotto));
    }

    private static Consumer<Rank> outputStatistics(Lottos lottos, WinningLotto winningLotto) {
        return rank -> {
            int countOfMatchNumber = lottos.getRankCount(winningLotto, rank);

            System.out.printf("%s개 일치", rank.getCountOfMatch());
            if (rank.isSecond()) {
                System.out.print(", 보너스 볼 일치");
            }
            System.out.printf("(%s원)- %s개\n", rank.getWinningMoney(), countOfMatchNumber);
        };
    }

    public static void outputRevenueRate(Lottos lottos, WinningLotto winningLotto) {
        LottoNumbers winningLottoNumbers = winningLotto.getWinningLottoNumbers();
        LottoNumber bonusBall = winningLotto.getBonusBall();

        double revenueRate = lottos.getRevenueRate(winningLottoNumbers, bonusBall);
        System.out.printf("총 수익률은 %.2f입니다.", revenueRate);
    }
}

