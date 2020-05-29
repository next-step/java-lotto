package study.lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lotto {
    private static final List<Integer> LOTTO_NUMBER_BASE = new ArrayList<>();

    private List<Integer> lottoNumbers = new ArrayList<>();

    static {
        for(int i=1; i<46; i++) {
            LOTTO_NUMBER_BASE.add(i);
        }
    }

    public static Lotto generate() {
        Lotto lotto = new Lotto();
        lotto.lottoNumbers = lotto.generateLottoNumbers();

        return lotto;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    private List<Integer> generateLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBER_BASE);

        return LOTTO_NUMBER_BASE.subList(0, 6);
    }
}
