package lotto.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.model.Count;
import lotto.model.Lotto;
import lotto.model.LottoNumber;
import lotto.model.Rank;

public class OutputView {

    private static final String BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private static final String LOSS_GUIDE_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---------";
    private static final String NOTHING = "";
    private static final String MANUAL = "수동으로";
    private static final String AUTO = "장 자동으로";
    private static final String COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String MATCH = "개 일치";
    private static final String PARENTHESES_START = "(";
    private static final String PARENTHESES_END = ")- ";
    private static final String COUNT = "개";
    private static final String TOTAL_WINNING_RATE = "총 수익률은";
    private static final String END_OF_SENTENCE = "입니다";

    private static void printLottoCount(Count count) {
        System.out.println(
            MANUAL + count.getManualLottoCount() + AUTO + count.getAutoLottoCount()
                + COUNT_MESSAGE);
    }

    public static void printLottos(Count count, List<Lotto> lottos) {
        printLottoCount(count);
        for (Lotto lotto : lottos) {
            List<Integer> list = lotto.getLottoNumbers().stream().map(LottoNumber::getNumber)
                .collect(
                    Collectors.toList());
            System.out.println(list);
        }
        System.out.println();
    }

    public static void printStatistics(Map<Rank, Integer> rankMap, double benefits) {
        String bonusMessage;
        System.out.println(WINNING_STATISTICS_MESSAGE);
        for (Rank key : rankMap.keySet()) {
            bonusMessage = addMessageForBonus(key);
            System.out.println(
                key.getMatchCount() + MATCH + bonusMessage + PARENTHESES_START + key.getReward()
                    + PARENTHESES_END
                    + rankMap.get(key)
                    + COUNT);
        }
        printBenefits(benefits);
    }

    private static String addMessageForBonus(Rank rank) {
        if (rank == Rank.SECOND) {
            return BONUS_BALL_MESSAGE;
        }
        return NOTHING;
    }

    private static void printBenefits(double benefits) {
        System.out.print(TOTAL_WINNING_RATE + benefits + END_OF_SENTENCE);
        if (benefits < 1) {
            System.out.println(LOSS_GUIDE_MESSAGE);
        }
    }
}

