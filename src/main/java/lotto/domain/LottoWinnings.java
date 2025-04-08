package lotto.domain;

import java.util.List;

public class LottoWinnings extends Lotto {
    private final LottoNumber bonusNumber;

    public LottoWinnings(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = new LottoNumber(bonusNumber);
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Bonus number must not be one of the winning numbers.");
        }
    }

    public boolean isBonusMatch(LottoNumber number) {
        return bonusNumber.equals(number);
    }

    public LottoPrize countMatches(Lotto lotto) {
        int count = 0;
        boolean bonusMatch = false;
        for (LottoNumber number : lotto.getNumbers()) {
            if (getNumbers().contains(number)) {
                count++;
            }
            if (isBonusMatch(number)) {
                bonusMatch = true;
            }
        }
        return LottoPrize.from(count, bonusMatch);
    }
}