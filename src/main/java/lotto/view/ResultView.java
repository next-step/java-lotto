package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Lottos;
import lotto.domain.Rewards;
import lotto.enums.Rank;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class ResultView {
    private ResultView() {
    }

    public static void printLottoCount(int totalCount, int manualCount) {
        System.out.printf("수동으로 %d장, 자동으로 %d개를 구매했습니다.%n", manualCount, totalCount-manualCount);
    }

    public static void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getValues()) {
            List<LottoNumber> lottoNumbers = lotto.getLottoNumbers();
            lottoNumbers.sort(Comparator.comparing(LottoNumber::getNumber));
            System.out.println(lottoNumbers);
        }
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
