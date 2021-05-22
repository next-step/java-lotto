package lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumberCreator{
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<LottoNumber> lottoNumbers;

    public LottoNumberCreator() {
        this.lottoNumbers = new ArrayList<>();
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
        shuffleLottoNumbers();
    }

    private void shuffleLottoNumbers() {
        Collections.shuffle(lottoNumbers);
    }

    public Lotto makeLotto() {
        return new Lotto(lottoNumbers.subList(0, LOTTO_NUMBER_COUNT));
    }
}
