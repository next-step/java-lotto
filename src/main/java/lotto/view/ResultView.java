package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Rank;

import java.util.Map;

import static common.message.OutputMessage.*;

public class ResultView {

    private static final String MESSAGE_COUNT = "%d개 일치 (%d원)- %d개%n";
    private static final String MESSAGE_PROFIT = "총 수익률은 %.2f입니다.(기준이 1이기 때문에 결과적으로 %s이라는 의미임)%n";

    private static final String PROFIT = "이익";
    private static final String LOSS = "손해";

    public static void printPurchasedLotto(Lottos lottos) {
        System.out.println(lottos.size() + PURCHASED);

        for (Lotto lotto : lottos.getValues()) {
            System.out.println(lotto);
        }
    }

    public static void printStatistics(Map<Rank, Integer> result, double profitRate) {
        System.out.println(MESSAGE_RESULT_HEADER);
        System.out.println(MESSAGE_SEPARATOR);

        for (Rank rank : Rank.values()) {
            int count = result.getOrDefault(rank, 0);
            System.out.printf(MESSAGE_COUNT, rank.getMatchCount(), rank.getReward(), count);
        }

        String profitState = profitRate >= 1.0 ? PROFIT : LOSS;
        System.out.printf(MESSAGE_PROFIT, profitRate, profitState);
    }
}
