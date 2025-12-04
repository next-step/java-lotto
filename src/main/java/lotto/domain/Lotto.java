package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;

public class Lotto {
    private final Set<LottoNumber> numbers;

    public Lotto(int... numbers) {
        this(intToList(numbers));
    }

    public Lotto(String... numbers) {
        this(stringToList(numbers));
    }

    public Lotto(String numbers) {
        this(stringToList(numbers.split(",")));
    }

    public Lotto(Set<LottoNumber> numbers) {
        validation(numbers);
        this.numbers = numbers;
    }

    private void validation(Set<LottoNumber> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private static Set<LottoNumber> stringToList(String... numbers) {
        return Arrays.stream(numbers)
                .map(LottoNumber::valueOf)
                .collect(Collectors.toSet());
    }

    private static Set<LottoNumber> intToList(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::valueOf)
                .collect(Collectors.toSet());
    }

    public int countMatchedNumbers(Lotto winningLotto) {
        return (int) numbers.stream().filter(winningLotto::contains).count();
    }

    public boolean contains(LottoNumber bonusNumber) {
        return this.numbers.contains(bonusNumber);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numbers);
    }

    @Override
    public String toString() {
        return String.valueOf(numbers);
    }
}
