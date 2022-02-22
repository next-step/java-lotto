package lotto.domain.lotto;

import java.util.LinkedHashMap;
import java.util.Map;
import lotto.domain.generator.LottoGenerator;

public class Answer {

    private static final String EXCEPTION_NUMBER_RANGE = "[ERROR] 숫자의 범위가 올바르지 않습니다.";
    private static final String EXCEPTION_NUMBER_DUPLICATED = "[ERROR] 당첨 번호와 보너스는 중복될 수 없습니다.";

    private final LottoNumbers answerNumbers;
    private final int bonus;

    public Answer(final LottoNumbers comparisonNumbers, final int bonus) {
        validateNumbers(comparisonNumbers);
        validateBonus(comparisonNumbers, bonus);

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

    private void validateNumbers(final LottoNumbers comparisonNumbers) {
        if (comparisonNumbers.size() != LottoGenerator.LOTTO_NUMBERS) {
            throw new IllegalArgumentException(EXCEPTION_NUMBER_RANGE);
        }
    }

    private void validateBonus(LottoNumbers comparisonNumbers, int bonus) {
        if (comparisonNumbers.hasBonus(new LottoNumber(bonus))) {
            throw new IllegalArgumentException(EXCEPTION_NUMBER_DUPLICATED);
        }
    }
}
