package lotto.domain.lotto;

import lotto.enums.Rank;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLotto implements Lotto {
    private List<Integer> numbers;
    private int bonusNumber;

    public WinningLotto(List<Integer> numbers, int bonusNumber) {
        Collections.sort(numbers);
        this.numbers = numbers;
        createBonusNumber(bonusNumber);
    }

    private void createBonusNumber(int bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("보너스볼 중복");
        }
        this.bonusNumber = bonusNumber;
    }

    public int checkMatchNumbers(BasicLotto lotto) {
        int matchCount = 0;
        for (int number : lotto.getNumbers()) {
            if (numbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public boolean checkBonusNumber(BasicLotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public Rank match(BasicLotto lotto) {
        return Rank.valueOf(checkMatchNumbers(lotto), checkBonusNumber(lotto));
    }

    @Override
    public String toString() {
        return numbers.stream()
            .map(String::valueOf)
            .collect(Collectors.joining(", ", "[", "]"));
    }
}
