package lotto.domain;

import java.util.List;

public class LottoWinnings extends Lotto {
    private final int bonusNumber;

    public LottoWinnings(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    private void validateBonusNumber(List<Integer> numbers, int bonusNumber) {
        if (bonusNumber < MIN_NUMBER || bonusNumber > MAX_NUMBER) {
            throw new IllegalArgumentException("Bonus number " + bonusNumber + " is out of valid range (" + MIN_NUMBER + "-" + MAX_NUMBER + ").");
        }
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("Bonus number must not be one of the winning numbers.");
        }
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public boolean isBonusMatch(int number) {
        return this.bonusNumber == number;
    }

    public LottoMatch countMatches(Lotto lotto) {
        int count = 0;
        boolean bonusMatch = false;
        for (Integer number : lotto.getNumbers()) {
            if (getNumbers().contains(number)) {
                count++;
            }
            if (isBonusMatch(number)) {
                bonusMatch = true;
            }
        }
        return new LottoMatch(count, bonusMatch);
    }

}