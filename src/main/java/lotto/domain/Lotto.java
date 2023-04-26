package lotto.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lotto {
    public static final int LOTTO_SIZE = 6;

    private final List<Number> numbers;

    public Lotto() {
        this.numbers = this.getNumbers();
    }

    private List<Number> getNumbers() {
        List<Integer> lottoNumbers = IntStream.rangeClosed(Number.MIN_NUMBER, Number.MAX_NUMBER)
                                              .boxed().collect(Collectors.toList());
        Collections.shuffle(lottoNumbers);
        return lottoNumbers.subList(0, LOTTO_SIZE).stream().map(Number::new).sorted().collect(Collectors.toList());
    }

    public Lotto(int... numbers) {
        List<Integer> intNumbers = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        validate(intNumbers);
        this.numbers = intNumbers.stream().map(Number::new).sorted().collect(Collectors.toList());
    }

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream().map(Number::new).sorted().collect(Collectors.toList());
    }

    private void validate(List<Integer> numbers) {
        if (new HashSet<>(numbers).size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또는 중복된 숫자 없이 6개가 필요합니다.");
        }
    }

    public List<Number> numbers() {
        return numbers;
    }

    public long matchNumber(List<Number> winNumbers) {
        return this.numbers.stream().filter(winNumbers::contains).count();
    }

    public long matchBonusNumber(Number bonusNumber) {
        return Collections.frequency(numbers, bonusNumber);
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

    @Override
    public String toString() {
        return "Lotto{" +
                "numbers=" + numbers +
                '}';
    }
}
