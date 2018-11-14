package lotto.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoNumberGenerator {

    private static final int LOTTO_NUMBER_LENGTH = 6;
    private static final int LOTTO_NUMBER_BOUND = 50;

    private LottoNumberGenerator() {

    }

    public static List<Integer> generate() {
        List<Integer> lottoNumbers = new ArrayList<>();
        for (int i = 0; i < LOTTO_NUMBER_LENGTH; i++) {
            lottoNumbers.add(generateRandomLotto());
        }
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private static int generateRandomLotto() {
        return new Random().nextInt(LOTTO_NUMBER_BOUND);
    }

}
