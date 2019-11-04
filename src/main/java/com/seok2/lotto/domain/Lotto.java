package com.seok2.lotto.domain;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    protected Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if(numbers.size() != LOTTO_SIZE){
            throw new IllegalArgumentException("로또 번호는 6개보다 많거나 적을 수 없습니다.");
        }
    }

    protected static Lotto generate(LottoStrategy strategy) {
        return new Lotto(strategy.generate());
    }

    protected static Lotto generate(String numbers) {
        return new Lotto(LottoNumber.parse(numbers));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
