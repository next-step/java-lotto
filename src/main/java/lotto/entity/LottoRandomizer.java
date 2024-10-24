package lotto.entity;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoRandomizer {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoRandomizer() {
        initNumber();
    }

    public List<LottoNumber> lottoShuffle() {
        Collections.shuffle(lottoNumbers);
        return lottoNumbers;
    }

    private List<LottoNumber> initNumber() {
        for (int i = MIN_LOTTO_NUMBER; i <= MAX_LOTTO_NUMBER; i++) {
            this.lottoNumbers.add(new LottoNumber(i));
        }
        return this.lottoNumbers;
    }
}


