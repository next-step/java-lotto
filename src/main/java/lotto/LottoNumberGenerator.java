package lotto;

import java.util.*;

public class LottoNumberGenerator {
    public static Set<Integer> generator() {
        Set<Integer> numbers = new TreeSet<>();
        while (numbers.size() < 6) {
            numbers.add(getRandomNumber());
        }
        return numbers;
    }
    private static int getRandomNumber() {
        Random random = new Random();
        return random.nextInt(45) + 1;
    }
}
