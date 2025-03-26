package lotto;

import java.util.ArrayList;
import java.util.List;

public class Lotto {
    public static final int PRICE = 1000;

    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }
}
