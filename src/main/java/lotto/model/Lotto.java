package lotto.model;

import lotto.LottoConstants;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private Set<LottoNumber> numbers;

    private Lotto(Set<Integer> numbers) {
        if (numbers.size() != LottoConstants.QUANTITY) {
            throw new IllegalArgumentException();
        }
        this.numbers = numbers.stream()
            .map(mapper -> LottoNumber.from(mapper.intValue()))
            .collect(Collectors.toSet());
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(new HashSet<>(numbers));
    }

    public static Lotto fromComma(String value) {
        return new Lotto(new HashSet<>(toIntegers(split(removeWhitespace(value)))));
    }

    private static String removeWhitespace(String value) {
        return value.replaceAll("\\s+","");
    }

    private static List<String> split(String value) {
        return Arrays.asList(value.split(","));
    }

    private static List<Integer> toIntegers(List<String> strings) {
        return strings.stream().map(Integer::valueOf).collect(Collectors.toList());
    }

    public int getMatchCount(Lotto targetLotto) {
        return (int) numbers.stream()
                .filter(number -> targetLotto.isContain(number))
                .count();
    }

    public boolean isContain(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    @Override
    public String toString() {
        return this.numbers.toString();
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
