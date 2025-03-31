package com.nextstep.camp.lotto.domain.vo;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private final List<LottoNumber> numbers;

    private static final int LOTTO_NUMBER_SIZE = 6;

    private LottoNumbers(List<Integer> rawNumbers) {
        if (rawNumbers.size() != LOTTO_NUMBER_SIZE || new HashSet<>(rawNumbers).size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복 없이 6개여야 합니다.");
        }
        this.numbers = rawNumbers.stream()
                .map(LottoNumber::of)
                .sorted(Comparator.comparingInt(LottoNumber::getValue))
                .collect(Collectors.toList());
    }

    public static LottoNumbers of(List<Integer> rawNumbers) {
        return new LottoNumbers(rawNumbers);
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
