package lotto.entity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomizer {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<Integer> lottoNumbers = new ArrayList<>();

    public LottoRandomizer() {
        initNumber();
    }

    public List<Integer> lottoShuffle() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private List<Integer> initNumber() {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            this.lottoNumbers.add(i);
        }
        return this.lottoNumbers;
    }
}


