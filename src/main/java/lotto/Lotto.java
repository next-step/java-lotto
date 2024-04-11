package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {

    private static final int LOTTO_PRICE = 1000;
    private static final int LOTTO_COUNT = 6;
    private static final int LOTTO_MAX = 45;

    public static int purchase(String number) {
        if (number == null || number.isEmpty()) {
            return 0;
        }
        int result = Integer.parseInt(number);
        return result / LOTTO_PRICE;
    }

    public static List<Integer> generate() {
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i < LOTTO_MAX; i++) {
            numbers.add(i);
        }

        Collections.shuffle(numbers);
        Collections.sort(numbers);

        return numbers.subList(0, LOTTO_COUNT);
    }

    public static int matchCount(List<Integer> winningNumbers, List<Integer> generateNumbers) {
        int result = 0;
        if (winningNumbers.size() != generateNumbers.size()) {
            return 0;
        }

        for (int winningNumber : winningNumbers) {
            if (generateNumbers.contains(winningNumber)) {
                result++;
            }
        }
        return result;
    }
}
