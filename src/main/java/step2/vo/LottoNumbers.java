package step2.vo;

import step2.service.Lotto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoNumbers {

    private static final int LOTTO_START_NUMBER = 1;

    private static final int LOTTO_END_NUMBER = 45;

    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int num = LOTTO_START_NUMBER; num <= LOTTO_END_NUMBER; num++) {
            lottoNumbers.add(new LottoNumber(num));
        }
        this.lottoNumbers = lottoNumbers;
    }

    public Lotto pickSixNumbers() {
        Collections.shuffle(lottoNumbers);
        List<LottoNumber> pickedNumbers = new ArrayList<>(lottoNumbers.subList(0, 6));
        Collections.sort(pickedNumbers);
        return new Lotto(pickedNumbers);
    }
}
