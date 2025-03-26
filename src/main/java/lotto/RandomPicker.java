package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomPicker {
    private final Random random;

    public RandomPicker(Random random) {
        this.random = random;
    }

    public List<Integer> pickNumbers(int count, List<Integer> availableNumbers) {
        var temp = new ArrayList<>(availableNumbers);
        Collections.shuffle(temp, random);
        return temp.subList(0, count);
    }
}
