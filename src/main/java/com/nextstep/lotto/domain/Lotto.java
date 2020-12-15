package com.nextstep.lotto.domain;

import java.util.List;

public class Lotto {
    private static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<LottoNumber> numbers) {
        if (numbers == null || numbers.isEmpty()) {
            throw new IllegalArgumentException("숫자는 빈값일 수 없습니다.");
        }

        if (numbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("숫자는 " + LOTTO_NUMBER_COUNT + "개만 허용됩니다.");
        }
        this.numbers = numbers;
    }

    public boolean contains(LottoNumber number ) {
        return numbers.contains(number);
    }

    public long matchedCount(Lotto otherLotto) {
        return otherLotto.numbers.stream()
                .filter(this::contains)
                .count();
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
