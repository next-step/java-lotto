package lotto.domain;

import java.util.List;

public class Lotto {
    public static final int PRICE = 1_000;
    public static final int LOTTO_SIZE = 6;

    public List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public boolean contains(Integer number) {
        return numbers.contains(number);
    }

    public int matchCountWith(Lotto other) {
        return (int) numbers.stream()
                .filter(number -> other.contains(number))
                .count();
    }
}
