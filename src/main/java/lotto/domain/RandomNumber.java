package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomNumber {

    private static final int MAX_NUMBER = 45;
    private static final int MIN_NUMBER = 1;
    private static final int COUNT = 6;

    private static List<Integer> numbers = new ArrayList<>();

    static {
        for (int number = MIN_NUMBER; number <= MAX_NUMBER; number++) {
            numbers.add(number);
        }
    }

    private RandomNumber() {
    }

    public static List<Integer> makeLottoNumbers() {
        Collections.shuffle(numbers);
        List<Integer> resultNumbers = numbers.subList(0, COUNT);
        Collections.sort(resultNumbers);
        return resultNumbers;
    }


}
