package com.cheolhyeonpark.lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoNumbers {

    private final List<Integer> numbers;

    public LottoNumbers() {
        this.numbers = generate();
        Collections.sort(this.numbers);
    }

    public List<Integer> generate() {
        List<Integer> source = new ArrayList<>();
        IntStream.rangeClosed(1, 45).forEach(source::add);
        Collections.shuffle(source);
        return source.stream().limit(6).collect(Collectors.toList());
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
