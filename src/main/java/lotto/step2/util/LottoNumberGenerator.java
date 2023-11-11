package lotto.step2.util;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class LottoNumberGenerator {
    private static final Random RANDOM = new Random();

    public static Set<Integer> generateLottoNumbers() {
        Set<Integer> lottoNumbers = new HashSet<>();

        while (lottoNumbers.size() < 6) {
            int number = RANDOM.nextInt(45) + 1;

            lottoNumbers.add(number);
        }

        return lottoNumbers;
    }
}
