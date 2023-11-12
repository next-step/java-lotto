package me.namuhuchutong.lotto.domain.generator;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import me.namuhuchutong.lotto.domain.Number;

public class RandomNumberGenerator implements NumberGenerator {

    private static final List<Number> RANDOM_NUMBERS;

    static {
        RANDOM_NUMBERS = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            RANDOM_NUMBERS.add(new Number(i));
        }
    }

    @Override
    public List<Number> createNumbers() {
        List<Number> numbers = new ArrayList<>(RANDOM_NUMBERS);
        Collections.shuffle(numbers);
        return numbers.subList(0, 6);
    }
}
