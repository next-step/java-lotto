package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("로또는 6자리여야 합니다.");
        }

        this.numbers = new ArrayList<>(numbers);
    }
}
