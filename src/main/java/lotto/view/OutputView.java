package lotto.view;

import java.util.stream.Collectors;
import lotto.domain.Ball;
import lotto.domain.BonusCondition;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Prize;
import lotto.domain.Prizes;

public class OutputView {

    private static final String PURCHASED_LOTTO_AMOUNT_MESSAGE = "%d개를 구매했습니다.\n";
    private static final String JUDGE_RESULT_HEADER_MESSAGE = "당첨 통계\n---------";
    private static final String JUDGE_RESULT_MESSAGE = "%s (%d원)- %d개\n";
    private static final String RETURN_RATE_MESSAGE = "총 수익률은 %.2f입니다.";
    private static final String JUDGE_DESCRIPTION = "개 일치";
    private static final String JUDGE_DESCRIPTION_WITH_BONUS = JUDGE_DESCRIPTION + ", 보너스 볼 일치";
    private static final String PURCHASED_LOTTO_DELIMITER = ", ";
    private static final String PURCHASED_LOTTO_PREFIX = "[";
    private static final String PURCHASED_LOTTO_SUFFIX = "]";

    public void printPurchasedLottos(Lottos lottos) {
        System.out.printf(PURCHASED_LOTTO_AMOUNT_MESSAGE, lottos.size());
        for (Lotto lotto : lottos.value()) {
            String lottoStr = lotto.balls().stream().mapToInt(Ball::number)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(PURCHASED_LOTTO_DELIMITER, PURCHASED_LOTTO_PREFIX,
                    PURCHASED_LOTTO_SUFFIX));
            System.out.println(lottoStr);
        }
    }

    public void printJudgeResult(int usedMoney, Prizes prizes) {
        System.out.println(JUDGE_RESULT_HEADER_MESSAGE);
        for (Prize prize : Prize.valuesWithoutNone()) {
            System.out.printf(
                JUDGE_RESULT_MESSAGE,
                prizeDescription(prize),
                prize.amount(),
                prizes.count(prize));
        }
        System.out.printf(RETURN_RATE_MESSAGE, prizes.calcReturnRate(usedMoney));
    }

    private String prizeDescription(Prize prize) {
        if (prize.bonusCondition() == BonusCondition.MUST_MATCH) {
            return prize.matchingCount() + JUDGE_DESCRIPTION_WITH_BONUS;
        }
        return prize.matchingCount() + JUDGE_DESCRIPTION;
    }
}
