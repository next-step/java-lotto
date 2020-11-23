package humbledude.lotto.domain;

import java.util.Set;

public class LottoWinningNumbers {

    private final LottoNumberSet winningNumbers;
    private final LottoNumber bonus;

    public LottoWinningNumbers(LottoNumberSet numbers, LottoNumber bonus) {
        winningNumbers = numbers;
        validateBonus(bonus);
        this.bonus = bonus;
    }

    public int getMatchedCountWith(LottoNumberSet numbers) {
        Set<LottoNumber> intersection = winningNumbers.intersection(numbers);

        return intersection.size();
    }

    public boolean isBonusMatched(LottoNumberSet numbers) {
        return numbers.contains(bonus);
    }

    private void validateBonus(LottoNumber bonus) {
        if (this.winningNumbers.contains(bonus)) {
            throw new IllegalStateException("보너스볼은 기존 6개와 겹칠 수 없습니다.");
        }

    }
}
