package com.cheolhyeonpark.lotto.domain;

import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public Rank getRank(WinningNumbers winningNumbers) {
        return Rank.findRank(countSameNumbersAs(winningNumbers));
    }

    private int countSameNumbersAs(WinningNumbers winningNumbers) {
        return Math.toIntExact(numbers.stream().filter(winningNumbers::anyMatch).count());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
