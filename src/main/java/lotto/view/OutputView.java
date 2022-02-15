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

    public static void printLottoCount(Count count) {
        System.out.println(
            "수동으로 " + count.getManualLottoCount() + "장 자동으로" + count.getAutoLottoCount()
                + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
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
                key.getMatchCount() + "개 일치" + bonusMessage + "(" + key.getReward() + ")- "
                    + rankMap.get(key)
                    + "개");
        }
        printBenefits(benefits);
    }

    private static String addMessageForBonus(Rank rank) {
        if (rank == Rank.SECOND) {
            return BONUS_BALL_MESSAGE;
        }
        return "";
    }

    private static void printBenefits(double benefits) {
        System.out.print("총 수익률은" + benefits + "입니다.");
        if (benefits < 1) {
            System.out.println(LOSS_GUIDE_MESSAGE);
        }
    }
}

