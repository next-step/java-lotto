package lotto.service;

import java.util.*;

public class LottoGenerator {

    private static final Random RANDOM = new Random();

    private LottoGenerator() {
    }

    public static List<Integer> generateLottoNumbers() {
        Set<Integer> numbersSet = new HashSet<>();

        while (numbersSet.size() < 6) {
            numbersSet.add(LottoGenerator.generateRandomNumber());
        }

        List<Integer> numbers = new ArrayList<>(numbersSet);

        shuffleLottoNumbers(numbers);

        return numbers;
    }

    private static int generateRandomNumber() {
        return RANDOM.nextInt(45) + 1;
    }

    private static void shuffleLottoNumbers(List<Integer> numbers) {
        Collections.shuffle(numbers);
    }
}
