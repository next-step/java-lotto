package step3.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RandomLottoNumGenerator {

    private static boolean[] duplicatedNumCheck = new boolean[46];

    public static List<Integer> createLottoNums() {
        init();
        List<Integer> numbers = new ArrayList<>();

        do {

            int number = (int) (Math.random() * 45) + 1;
            getIfNotDuplicated(numbers, number);

        } while (numbers.size() != 6);

        return numbers;
    }

    private static void getIfNotDuplicated(List<Integer> numbers, int number) {
        if (!duplicatedNumCheck[number]) {
            duplicatedNumCheck[number] = true;
            numbers.add(number);
        }
    }

    private static void init() {
        Arrays.fill(duplicatedNumCheck, false);
    }
}
