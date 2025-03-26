package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Rewards;
import lotto.enums.Rank;

import java.util.Arrays;
import java.util.Comparator;

public class ResultView {
    private ResultView() {
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getLottoNumbers().toString());
    }

    public static void printResultOverview() {
        System.out.println(System.lineSeparator() + "당첨 통계");
        System.out.println("---------");
    }

    public static void printResult(int initialAmount, Rewards rewards) {
        Arrays.stream(Rank.values())
                .filter(rank -> rank != Rank.MISS)
                .sorted(Comparator.reverseOrder())
                .forEach(rank -> {
                    String bonusMessage = (rank == Rank.SECOND) ? ", 보너스 볼 일치" : " ";
                    System.out.printf("%d개 일치%s(%d원)- %d개%n", rank.getCountOfMatch(), bonusMessage, rank.getWinningMoney(), rewards.getMatchCountsByRank(rank));
                });

        double rateOfReturn = rewards.getRateOfReturn(initialAmount);
        String additionalMessage = rateOfReturn < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "";
        System.out.printf("총 수익률은 %.2f입니다.%s", rateOfReturn, additionalMessage);
    }
}
