package com.nextstep.camp.lotto.domain.vo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    public LottoNumbers(List<Integer> rawNumbers) {
        if (rawNumbers.size() != 6 || new HashSet<>(rawNumbers).size() != 6) {
            throw new IllegalArgumentException("로또 번호는 중복 없이 6개여야 합니다.");
        }
        this.numbers = rawNumbers.stream()
                .map(LottoNumber::new)
                .sorted(Comparator.comparingInt(LottoNumber::getValue))
                .collect(Collectors.toList());
    }

    public int countMatch(LottoNumbers winningNumbers) {
        return (int) numbers.stream()
                .filter(winningNumbers::contains)
                .count();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
    }

    public List<LottoNumber> getNumbers() {
        return numbers;
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(n -> String.valueOf(n.getValue()))
                .collect(Collectors.joining(", ", "[", "]"));
    }
}
