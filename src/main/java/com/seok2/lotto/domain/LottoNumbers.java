package com.seok2.lotto.domain;

import com.seok2.lotto.exception.LottoDuplicateNumberException;
import com.seok2.lotto.exception.LottoLengthException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class LottoNumbers {


    private final Set<LottoNumber> numbers;

    private LottoNumbers(Set<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    static LottoNumbers of(Collection<LottoNumber> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        return new LottoNumbers(Collections.unmodifiableSet(new TreeSet<>(numbers)));
    }

    static LottoNumbers of(int... numbers) {
        return of(Arrays.stream(numbers)
            .mapToObj(LottoNumber::of)
            .collect(Collectors.toList()));
    }

    private static void validateSize(Collection<LottoNumber> numbers) {
        if (numbers.size() != Lotto.LOTTO_LENGTH) {
            throw new LottoLengthException();
        }
    }

    private static void validateDuplicate(Collection<LottoNumber> numbers) {
        Set<LottoNumber> identified = new HashSet<>(numbers);
        if (numbers.size() != identified.size()) {
            throw new LottoDuplicateNumberException();
        }
    }

    int match(LottoNumbers lottoNumbers) {
        Set<LottoNumber> copy = new HashSet<>(this.numbers);
        copy.retainAll(lottoNumbers.numbers);
        return copy.size();
    }

    boolean contains(LottoNumber lottoNumber) {
        return this.numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
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
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(numbers, that.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }
}
