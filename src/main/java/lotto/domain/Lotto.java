package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Lotto {
    public static final int LOTTO_NUMBER = 6;
    public static final int MIN_LOTTO_NUMBER = 1;
    public static final int MAX_LOTTO_NUMBER = 45;
    private List<Integer> numbers;

    public Lotto(String numbers) {
        this.numbers = validate(split(numbers));
    }

    public Lotto(List<Integer> numbers) {
        this.numbers = validate(numbers);
    }

    private List<Integer> validate(List<Integer> numbers) {
        if (numbers.size() != LOTTO_NUMBER) {
            throw new IllegalArgumentException("개수가 6개가 아닙니다.");
        }

        numbers.stream().forEach(number -> checkNumber(number));

        return numbers;
    }

    private void checkNumber(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 로또 번호가 될 수 없습니다.");
        }
        if (number > 45) {
            throw new IllegalArgumentException("로또 번호는 45를 넘어갈 수 없습니다.");
        }
    }
    private List<Integer> split(String numbers) {
        String[] number = numbers.split(", ");
        return Arrays.stream(number).map(Integer::parseInt).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return numbers.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", ", "[","]"));
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
