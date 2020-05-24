package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LottoGenerator {

    private final Random RANDOM  = new Random();

    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_NUMBER_MAX = 45;


    public Lotto autoGenerate() {
        List<Integer> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            lottoNumbers.add(RANDOM.nextInt(LOTTO_NUMBER_MAX) + 1);
        }

        return new Lotto(lottoNumbers);
    }
}
