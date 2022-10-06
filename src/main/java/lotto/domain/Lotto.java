package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    public int getMatchCount(List<Integer> collectNumberList) {
        int matchCount = 0;
        for (int number : this.numbers) {
            matchCount += getMatchCount(collectNumberList, number);
        }
        return matchCount;
    }

    public boolean isMatchToBonusNumber(int bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    private int getMatchCount(List<Integer> collectNumberList, int number) {
        if (collectNumberList.contains(number)) {
            return 1;
        }
        return 0;
    }

}
