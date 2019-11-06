package com.seok2.lotto.domain;

import static com.seok2.common.utils.StringUtils.split;

import com.seok2.lotto.exception.DuplicateLottoNumberException;
import com.seok2.lotto.exception.OutOfLottoLengthException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class Lotto {

    public static final Money PRICE = Money.of(1_000);
    private static final String NUMBERS_STRING_REGEX = "^[0-9,]+$";
    private static final int LOTTO_LENGTH = 6;

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<LottoNumber> numbers) {
        long count = numbers.stream()
            .distinct()
            .count();
        if(numbers.size() != count){
            throw new DuplicateLottoNumberException();
        }
        if (count > LOTTO_LENGTH) {
            throw new OutOfLottoLengthException();
        }
    }

    public static Lotto generate(LottoStrategy strategy) {
        return new Lotto(strategy.generate());
    }

    public static Lotto generate(String numbers) {
        return new Lotto(Arrays.stream(split(numbers))
            .map(String::trim)
            .map(Integer::parseInt)
            .map(LottoNumber::of)
            .collect(Collectors.toList()));
    }

    public int match(Lotto winning) {
        Set<LottoNumber> intersection = new HashSet<>(winning.numbers);
        intersection.retainAll(this.numbers);
        return intersection.size();
    }

    public boolean contains(LottoNumber number) {
        return numbers.contains(number);
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
        Lotto that = (Lotto) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
