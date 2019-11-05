package com.seok2.lotto.domain;

import com.seok2.common.utils.StringUtils;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    private static final int LOTTO_SIZE = 6;

    private final List<LottoNumber> numbers;

    protected Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개보다 많거나 적을 수 없습니다.");
        }
    }

    public static Lotto generate(LottoStrategy strategy) {
        return new Lotto(strategy.generate());
    }

    public static Lotto generate(String numbers) {
        return new Lotto(Arrays.stream(StringUtils.split(numbers))
                        .map(Integer::parseInt)
                        .map(LottoNumber::new)
                        .collect(Collectors.toList()));
    }

    protected Rank check(Lotto winning) {
        return Rank.ofMatches(match(winning));
    }

    private int match(Lotto winning) {
        Set<LottoNumber> intersection = new HashSet<>(winning.numbers);
        intersection.retainAll(this.numbers);
        return intersection.size();
    }

    @Override
    public String toString() {
        Collections.sort(numbers);
        return numbers.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
