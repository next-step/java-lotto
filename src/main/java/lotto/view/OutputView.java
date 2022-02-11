package lotto.view;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.Rank;

public class OutputView {

    private static final String BONUS_BALL_MESSAGE = ", 보너스 볼 일치";
    private static final String LOSS_GUIDE_MESSAGE = "(기준이 1이기 때문에 결과적으로 손해라는 의미임)";
    private static final String WINNING_STATISTICS_MESSAGE = "\n당첨 통계\n---------";

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottos(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getLottoNumbers()));
    }

    public static void printStatistics(Map<Rank, Integer> ranks, double benefits) {
        String bonusMessage;
        System.out.println(WINNING_STATISTICS_MESSAGE);
        Iterator<Rank> keys = ranks.keySet().iterator();
        while (keys.hasNext()) {
            Rank key = keys.next();
            bonusMessage = addMessageForBonus(key);
            System.out.println(
                key.getMatchCount() + "개 일치" + bonusMessage + "(" + key.getReward() + ")- "
                    + ranks.get(key)
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

