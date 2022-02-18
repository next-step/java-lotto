package lotto.domain.lotto;

import java.util.Map;

public class Answer {

    private static final String EXCEPTION_BONUS_DUPLICATED = "[ERROR] 당첨 번호에 보너스가 포함될 수 없습니다.";

    private final Ticket answerNumbers;
    private final Number bonus;

    public Answer(final Ticket answerNumbers, final Number bonus) {
        validateBonus(answerNumbers, bonus);

        this.answerNumbers = answerNumbers;
        this.bonus = bonus;
    }

    private void validateBonus(final Ticket answerNumbers, final Number bonus) {
        if (answerNumbers.hasBonus(bonus)) {
            throw new IllegalArgumentException(EXCEPTION_BONUS_DUPLICATED);
        }
    }

    public Map<Rank, Integer> getComparisonPrizeMap(final Tickets tickets) {
        return tickets.getComparisonPrizeMap(answerNumbers, bonus);
    }
}
