package lotto.domain.lotto;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.generator.LottoGenerator;

public class Answer {

    private static final String EXCEPTION_NUMBER_RANGE = "[ERROR] 숫자의 범위가 올바르지 않습니다.";

    private final Numbers answerNumbers;
    private final int bonus;

    public Answer(final Numbers comparisonNumbers, final int bonus) {
        validateNumbers(comparisonNumbers);
        validateBonus(bonus);

        this.answerNumbers = comparisonNumbers;
        this.bonus = bonus;
    }

    public Map<Rank, Integer> compare(final Tickets tickets) {
        Map<Rank, Integer> prizeMap = new LinkedHashMap<>();

        for (Ticket ticket : tickets.get()) {
            int matches = ticket.matches(answerNumbers.get());
            Rank rank = Rank.getRank(matches, ticket.hasBonus(bonus));
            prizeMap.put(rank, prizeMap.getOrDefault(rank, 0) + 1);
        }

        return prizeMap;
    }

    private void validateNumbers(final Numbers comparisonNumbers) {
        if (!validateEachNumberInRange(comparisonNumbers) || !validateCountOfNumbers(
            comparisonNumbers)) {
            throw new IllegalArgumentException(EXCEPTION_NUMBER_RANGE);
        }
    }

    private boolean validateCountOfNumbers(final Numbers comparisonNumbers) {
        return comparisonNumbers.get().size() == LottoGenerator.LOTTO_NUMBERS;
    }

    private boolean validateEachNumberInRange(final Numbers comparisonNumbers) {
        return comparisonNumbers.get().stream()
            .allMatch(this::isNumberInRange);
    }

    private void validateBonus(final int bonus) {
        if (!isNumberInRange(bonus)) {
            throw new IllegalArgumentException(EXCEPTION_NUMBER_RANGE);
        }
    }

    private boolean isNumberInRange(final int number) {
        return (LottoGenerator.START_NUMBER <= number && number <= LottoGenerator.END_NUMBER);
    }
}
