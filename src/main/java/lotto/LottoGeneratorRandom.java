package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoGeneratorRandom implements LottoGenerator {
    private int TO_INDEX = 6;
    private final int LOTTO_BOUND = 45;

    public List<Integer> lottoGeneratorBase() {
        List<Integer> lottoNumbers = new ArrayList<>(LOTTO_BOUND);

        for (int i = 0; i < LOTTO_BOUND; i++) {
            lottoNumbers.add(i + 1);
        }
        return lottoNumbers;
    }

    public List<Integer> lottoGeneration() {
        List<Integer> baseNumbers = lottoGeneratorBase();
        Collections.shuffle(baseNumbers);
        return baseNumbers.subList(0, TO_INDEX);
    }
}
