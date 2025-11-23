package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Lotto {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private final Set<LottoNumber> numbers;

    public Lotto(int... intNumbers) {
        this(numbersToSet(intNumbers));
    }

    public Lotto(Set<LottoNumber> numbers) {
        validateInputSize(numbers.size());
        this.numbers = numbers;
    }

    private static Set<LottoNumber> numbersToSet(int[] intNumbers) {
        Set<LottoNumber> numbers = new HashSet<>();
        for (int number : intNumbers) {
            numbers.add(LottoNumber.of(number));
        }
        return numbers;
    }

    public static Lotto from(List<Integer> intNumbers) {
        return new Lotto(createLottoNumbers(intNumbers));
    }
    private static void validateInputSize(int length) {
        if (length != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또 번호는 중복없이 6개여야 합니다.");
        }
    }

    private static Set<LottoNumber> createLottoNumbers(List<Integer> intNumbers) {
        Set<LottoNumber> lottoNumbers = new HashSet<>();
        for (Integer number : intNumbers) {
            lottoNumbers.add(LottoNumber.of(number));
        }

        return lottoNumbers;
    }

    public List<Integer> getNumbers() {
        List<Integer> result = new ArrayList<>();
        for (LottoNumber number : numbers) {
            result.add(number.getValue());
        }
        Collections.sort(result);
        return List.copyOf(result);
    }

    public boolean contains(LottoNumber number) {
        return this.numbers.contains(number);
    }

    public int countMatch(Lotto other) {
        return (int) this.numbers.stream()
                .filter(other::contains)
                .count();

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
}
