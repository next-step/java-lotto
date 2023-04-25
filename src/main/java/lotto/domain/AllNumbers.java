package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class AllNumbers {

    private static final int BEGIN_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;

    public static List<Integer> value() {
        return initNumbers();
    }

    private static List<Integer> initNumbers() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = BEGIN_LOTTO_NUMBER; i <= END_LOTTO_NUMBER; i++) {
            numbers.add(i);
        }
        return numbers;
    }
}
