package lotto.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

public class Lotto {
    private final List<LottoNumber> numbers;

    public Lotto(int... numbers) {
        this(intToList(numbers));
    }

    public Lotto(String... numbers) {
        this(stringToList(numbers));
    }

    public Lotto(List<LottoNumber> numbers) {
        validation(numbers);
        this.numbers = numbers;
    }
    private void validation(List<LottoNumber> numbers) {
        if (isDuplication(numbers)) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또 번호는 6개여야 합니다.");
        }
    }

    private boolean isDuplication(List<LottoNumber> numbers) {
        return new HashSet<>(numbers).size() != numbers.size();
    }

    private static List<LottoNumber> stringToList(String... numbers) {
        return Arrays.stream(numbers)
                .map(LottoNumber::valueOf)
                .toList();
    }

    private static List<LottoNumber> intToList(int... numbers) {
        return Arrays.stream(numbers)
                .mapToObj(LottoNumber::valueOf)
                .toList();
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
