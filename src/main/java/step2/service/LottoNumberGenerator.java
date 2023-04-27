package step2.service;

import step2.vo.LottoNumber;
import step2.vo.LottoNumbers;

import java.util.ArrayList;
import java.util.List;

public class LottoNumberGenerator {

    private static final int LOTTO_START_NUMBER = 1;

    private static final int LOTTO_END_NUMBER = 45;

    private final LottoNumbers lottoNumbers;

    public LottoNumberGenerator() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int num = LOTTO_START_NUMBER; num <= LOTTO_END_NUMBER; num++) {
            lottoNumbers.add(new LottoNumber(num));
        }
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    public Lotto generateLottoNumbers() {
        return new Lotto(new LottoNumbers(lottoNumbers.pickSixNumbers()));
    }
}
