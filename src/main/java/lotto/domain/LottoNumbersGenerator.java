package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.intf.NumbersGenerator;

public class LottoNumbersGenerator implements NumbersGenerator {
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbersGenerator() {
        for (int i = LottoNumber.LOTTO_NUMBER_MIN; i <= LottoNumber.LOTTO_NUMBER_MAX; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    public LottoNumbersGenerator(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    @Override
    public LottoNumbers generateLottoNumbers() {
        Collections.shuffle(this.lottoNumbers);
        List<LottoNumber> resultLottoNumbers = new ArrayList<>();
        for (int i = 0; i < LottoNumbers.LOTTO_NUMBERS_COUNT; i++) {
            resultLottoNumbers.add(this.lottoNumbers.get(i));
        }
        return new LottoNumbers(resultLottoNumbers);
    }
}
