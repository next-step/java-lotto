package lotto.domain.lotto;

import lotto.enums.Rank;

import java.util.Collections;
import java.util.List;

public class WinningLotto implements Lotto {
    private Numbers numbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        Collections.sort(numbers);
        this.numbers = new Numbers(numbers);
        createBonusNumber(bonusNumber);
    }

    private void createBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼 중복");
        }
        this.bonusNumber = bonusNumber;
    }

    public Rank match(BasicLotto lotto) {
        return Rank.valueOf(checkMatchNumbers(lotto), checkBonusNumber(lotto));
    }

    private int checkMatchNumbers(BasicLotto lotto) {
        return numbers.matchCount(lotto.getNumbers());
    }

    private boolean checkBonusNumber(BasicLotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
