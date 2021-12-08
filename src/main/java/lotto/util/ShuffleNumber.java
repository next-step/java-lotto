package lotto.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShuffleNumber {

    private ShuffleNumber() {
    }

    public static List<Integer> shuffle(int start, int end) {
        List<Integer> numbers = new ArrayList<>();
        for (int i = start; i < end; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers;
    }
}
