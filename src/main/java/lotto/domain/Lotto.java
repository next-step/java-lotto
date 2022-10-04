package lotto.domain;

import java.util.List;

public class Lotto {
    private final List<Integer> numbers;

    Lotto() {
        this.numbers = NumberGenerator.pickLottoNumber();
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

    private int getMatchCount(List<Integer> collectNumberList, int number){
        if (collectNumberList.contains(number)) {
            return 1;
        }
        return 0;
    }

}
