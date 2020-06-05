package com.cheolhyeonpark.lotto.domain.number;

import com.cheolhyeonpark.lotto.domain.Rank;

public class WinningNumbers {

    private final Numbers winningNumbers;
    private final Number bonusNumber;

    public WinningNumbers(Numbers winningNumbers, Number bonusNumber) {
        validate(winningNumbers, bonusNumber);
        this.winningNumbers = winningNumbers;
        this.bonusNumber = bonusNumber;
    }

    private void validate(Numbers winningNumbers, Number bonusNumber) {
        if (winningNumbers.anyMatch(bonusNumber)) {
            throw new IllegalArgumentException("Bonus number cannot be duplicated with winning number.");
        }
    }

    public Rank getRank(Numbers numbers) {
        return Rank.findRank(countSameNumbersAs(numbers), hasBonus(numbers));
    }

    private int countSameNumbersAs(Numbers numbers) {
        return winningNumbers.countSameNumbersAs(numbers);
    }

    private boolean hasBonus(Numbers numbers) {
        return numbers.anyMatch(bonusNumber);
    }
}
