package com.seok2.lotto.domain;

import java.util.Objects;

public class Lotto {

    public static final Money PRICE = Money.of(1_000);

    private final LottoNumbers numbers;
    private final boolean auto;

    private Lotto(LottoNumbers numbers, boolean auto) {
        this.numbers = numbers;
        this.auto = auto;
    }

    public static Lotto generate(LottoStrategy strategy) {
        return new Lotto(LottoNumbers.of(strategy.generate()), true);
    }

    public static Lotto generate(String numbers) {
        return new Lotto(LottoNumbers.of(numbers), false);
    }

    public int match(Lotto winning) {
        return numbers.match(winning.numbers);
    }

    public boolean contains(LottoNumber bonus) {
        return numbers.contains(bonus);
    }

    public boolean isAuto() {
        return this.auto;
    }

    public boolean isManual() {
        return !this.auto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto that = (Lotto) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }


}
