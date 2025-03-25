package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Reward;
import lotto.domain.Rewards;

import java.util.Map;

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
        Map<Integer, Integer> matchCounts = rewards.getMatchCounts();
        for (int i = 3; i <= 6; i++) {
            System.out.printf("%d개 일치(%d원)- %d개%n", i, Reward.PRIZES.get(i), matchCounts.getOrDefault(i, 0));
        }

        double rateOfReturn = rewards.getRateOfReturn(initialAmount);
        String additionalMessage = rateOfReturn < 1 ? "(기준이 1이기 때문에 결과적으로 손해라는 의미임)" : "";
        System.out.printf("총 수익률은 %.2f입니다.%s", rateOfReturn, additionalMessage);
    }
}
