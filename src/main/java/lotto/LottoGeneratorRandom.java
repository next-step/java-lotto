package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoGeneratorRandom implements LottoGenerator {
    private int TO_INDEX = 6;
    private final int LOTTO_BOUND = 45;
    private final List<Integer> LOTTO_NUMBER = new ArrayList<>(LOTTO_BOUND);

    public LottoGeneratorRandom() {
        for (int i = 0; i < LOTTO_BOUND; i++) {
            this.LOTTO_NUMBER.add(i + 1);
        }
    }

    public List<Integer> lottoGeneration() {
        Collections.shuffle(this.LOTTO_NUMBER);
        return this.LOTTO_NUMBER.subList(0, TO_INDEX);
    }
}
