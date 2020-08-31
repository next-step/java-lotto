package kr.heesu.lotto.domain;

import kr.heesu.lotto.enums.ExceptionMessage;
import kr.heesu.lotto.enums.Rank;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    private static final int SIZE = 6;

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static Lotto of(List<LottoNumber> numbers) {
        validationCheck(numbers);
        return new Lotto(numbers);
    }

    private static void validationCheck(List<LottoNumber> numbers) {
        if (numbers.size() != SIZE) {
            throw new IllegalArgumentException(ExceptionMessage.EXCEPTION_FOR_LOTTO.getMessage());
        }
    }

    public boolean contain(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public Rank match(WinningLotto winningLotto) {
        Long count = this.numbers.stream()
                .filter(winningLotto::contains)
                .count();

        return Rank.valueOf(count, this.contain(winningLotto.getBounusNumber()));
    }

    @Override
    public String toString() {
        return "[" + this.numbers.stream()
                .map(LottoNumber::toString)
                .collect(Collectors.joining(", ")) + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Lotto) {
            Lotto other = (Lotto) obj;
            return this.numbers.equals(other.numbers);
        }
        return false;
    }

    @Override
    public int hashCode() {
        int code = this.numbers.stream()
                .mapToInt(LottoNumber::hashCode)
                .sum();
        return Objects.hash(code);
    }
}

