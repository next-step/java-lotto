package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.ExceptionMessage;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private static final int SIZE = 6;

    private final Set<LottoNumber> lotto;

    private Lotto(Set<LottoNumber> numbers) {
        this.lotto = numbers;
    }

    public static Lotto of(List<LottoNumber> numbers) {
        Set<LottoNumber> lotto = new HashSet<>(numbers);
        validationCheck(lotto);

        return new Lotto(lotto);
    }

    public static Lotto of(String userInput) {
        String[] values = userInput.split(", ");
        Set<LottoNumber> lotto = Arrays.stream(values)
                .map(LottoNumber::of)
                .collect(Collectors.toSet());

        validationCheck(lotto);

        return new Lotto(lotto);
    }

    private static void validationCheck(Set<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            numbers.forEach(System.out::println);
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_FOR_LOTTO.getMessage());
        }
    }

    public boolean contain(LottoNumber lottoNumber) {
        return lotto.contains(lottoNumber);
    }

    public Long contains(Lotto lotto) {
        return this.lotto.stream()
                .filter(lotto::contain)
                .count();
    }

    @Override
    public String toString() {
        return "[" + lotto.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ")) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Lotto) {
            Lotto other = (Lotto) obj;
            return this.lotto.equals(other.lotto);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int code = lotto.stream()
                .mapToInt(LottoNumber::hashCode)
                .sum();
        return Objects.hash(code);
    }
}

