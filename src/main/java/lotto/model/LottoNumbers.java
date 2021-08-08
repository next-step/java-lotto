package lotto.model;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {
    private static final int LOTTO_NUMBER_MIN_LENGTH = 0;
    private static final int LOTTO_NUMBER_MAX_LENGTH = 6;

    private List<Integer> lottoNumber = new ArrayList<>();

    public LottoNumbers() {
        LottoNumber lottoNumber = new LottoNumber();
        lottoNumber.shuffle();
        this.lottoNumber = lottoNumber.getLottoNumber()
                .subList(LOTTO_NUMBER_MIN_LENGTH, LOTTO_NUMBER_MAX_LENGTH);

    }

    public List<Integer> selectedNumber() {
        return this.lottoNumber;
    }
}
