package lotto.views;

import lotto.domains.EarningRate;
import lotto.domains.Scores;
import lotto.enums.Message;
import lotto.enums.Prize;

public final class Reporter {

    private Reporter() {
    }

    public static void report(Scores scores, EarningRate earningRate) {
        Display.show(Message.RESULT_HEAD);
        Display.show(Message.RESULT_3, scores.of(Prize.THREE));
        Display.show(Message.RESULT_4, scores.of(Prize.FOUR));
        Display.show(Message.RESULT_5, scores.of(Prize.FIVE));
        Display.show(Message.RESULT_BONUS, scores.of(Prize.BONUS));
        Display.show(Message.RESULT_6, scores.of(Prize.SIX));
        Display.show(Message.RESULT_TOTAL, scores.totalMoney());
        Display.show(Message.RESULT_TAIL, earningRate);
    }
}
