package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGeneratorRandom implements LottoGenerator {
    final int LOTTO_BOUND = 45;
    final List<Integer> LOTTO_NUMBER = new ArrayList<>(LOTTO_BOUND);

    public LottoGeneratorRandom() {
        for (int i = 0; i < LOTTO_BOUND; i++) {
            LOTTO_NUMBER.add(i + 1);
        }
    }

    public List<Integer> lottoGeneration() {
        Collections.shuffle(LOTTO_NUMBER);
        return LOTTO_NUMBER.subList(0, 6);
    }
}
