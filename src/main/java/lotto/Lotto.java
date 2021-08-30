package lotto;

import java.util.Collections;
import java.util.List;

public class Lotto {
    public static final int MAX_NUMBER = 45;
    public static final int MIN_NUMBER = 1;
    public static final int LOTTO_SIZE = 6;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 6개입니다.");
        }

        if (numbers.stream().anyMatch((number) -> number > MAX_NUMBER || number < MIN_NUMBER)) {
            throw new IllegalArgumentException("로또 번호는 1 ~ 45 사이입니다.");
        }

        if (numbers.stream().distinct().count() != LOTTO_SIZE) {
            throw new IllegalArgumentException("로또 번호는 중복될 수 없습니다.");
        }

        Collections.sort(numbers);

        this.numbers = numbers;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
