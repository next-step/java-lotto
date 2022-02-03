package lotto.domain.lotto;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.generator.LottoGenerator;

public class Answer {

    private final Numbers answerNumbers;
    private final int bonus;

    public Answer(final Numbers comparisonNumbers, final int bonus) {
        validateNumbers(comparisonNumbers);
        validateBonus(bonus);

        this.answerNumbers = comparisonNumbers;
        this.bonus = bonus;
    }

    private void validateNumbers(Numbers comparisonNumbers) {
        if (!validateEachNumberInRange(comparisonNumbers) || !validateCountOfNumbers(comparisonNumbers)) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위가 올바르지 않습니다.");
        }
    }

    private boolean validateCountOfNumbers(Numbers comparisonNumbers) {
        return comparisonNumbers.get().size() == LottoGenerator.LOTTO_NUMBERS;
    }

    private boolean validateEachNumberInRange(Numbers comparisonNumbers) {
        return comparisonNumbers.get().stream()
                .allMatch(this::isNumberInRange);
    }

    private void validateBonus(int bonus) {
        if (!isNumberInRange(bonus)) {
            throw new IllegalArgumentException("[ERROR] 숫자의 범위가 올바르지 않습니다.");
        }
    }

    private boolean isNumberInRange(final int number) {
        return (LottoGenerator.START_NUMBER <= number && number <= LottoGenerator.END_NUMBER);
    }

    public Map<Rank, Integer> compare(Tickets tickets) {
        Map<Rank, Integer> resultMap = new LinkedHashMap<>();

        for (Ticket ticket: tickets.get()) {
            int matches = ticket.matches(answerNumbers.get());
            Rank rank = Rank.getRank(matches, ticket.checkBonus(bonus));
            resultMap.put(rank, resultMap.getOrDefault(rank, 0) + 1);
        }

        return resultMap;
    }
}
