package lotto.service;

import java.util.*;

public class LottoGenerator {

    private static final Random RANDOM = new Random();

    private LottoGenerator() {
    }

    public static List<Integer> generateLottoNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();

        while (uniqueNumbers.size() < 6) {
            uniqueNumbers.add(LottoGenerator.generateRandomNumber());
        }

        return new ArrayList<>(uniqueNumbers);
    }

    private static int generateRandomNumber() {
        return RANDOM.nextInt(45) + 1;
    }

}
