package lotto.domain.lotto;

import java.util.Map;
import lotto.domain.generator.LottoGenerator;

public class Answer {

    private static final String EXCEPTION_NUMBER_RANGE = "[ERROR] 숫자의 범위가 올바르지 않습니다.";
    private static final String EXCEPTION_BONUS_DUPLICATED = "[ERROR] 당첨 번호에 보너스가 포함될 수 없습니다.";

    private final Numbers answerNumbers;
    private final int bonus;

    public Answer(final Numbers comparisonNumbers, final int bonus) {
        validateNumbers(comparisonNumbers);
        validateBonus(comparisonNumbers, bonus);

        this.answerNumbers = comparisonNumbers;
        this.bonus = bonus;
    }

    public Map<Rank, Integer> getComparisonPrizeMap(final Tickets tickets) {
        return tickets.getComparisonPrizeMap(answerNumbers, bonus);
    }


    private void validateNumbers(final Numbers comparisonNumbers) {
        if (comparisonNumbers.size() != LottoGenerator.LOTTO_NUMBERS) {
            throw new IllegalArgumentException(EXCEPTION_NUMBER_RANGE);
        }
    }

    private void validateBonus(Numbers comparisonNumbers, int bonus) {
        if (comparisonNumbers.hasBonus(new Number(bonus))) {
            throw new IllegalArgumentException(EXCEPTION_BONUS_DUPLICATED);
        }
    }
}
