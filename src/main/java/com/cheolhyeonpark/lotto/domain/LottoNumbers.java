package com.cheolhyeonpark.lotto.domain;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class LottoNumbers {

    private final List<Integer> numbers;

    public LottoNumbers(List<Integer> numbers) {
        Collections.sort(numbers);
        this.numbers = numbers;
    }

    public Rank getRank(List<Integer> winningNumbers) {
        return Rank.findRank(countSameNumbersAs(winningNumbers));
    }

    private int countSameNumbersAs(List<Integer> winningNumbers) {
        return Math.toIntExact(numbers.stream()
                .filter(number -> winningNumbers.stream().anyMatch(Predicate.isEqual(number))).count());
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
