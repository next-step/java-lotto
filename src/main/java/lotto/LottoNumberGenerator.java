package lotto;

import java.util.*;

public class LottoGenerator {
    public static Lotto generator() {
        Set<Integer> numbers = new TreeSet<>();
        while (numbers.size() < 6) {
            numbers.add(getRandomNumber());
        }
        return new Lotto(numbers);
    }

    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(45) + 1;
    }
}
