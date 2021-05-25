package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import lotto.intf.NumbersGenerator;

public class LottoNumbersGenerator implements NumbersGenerator {
    public static final String SPLIT_DELIMITER = ",";
    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    public LottoNumbersGenerator() {
        for (int i = LottoNumber.LOTTO_NUMBER_MIN; i <= LottoNumber.LOTTO_NUMBER_MAX; i++) {
            lottoNumbers.add(new LottoNumber(i));
        }
    }

    public LottoNumbersGenerator(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = new ArrayList<>(lottoNumbers);
    }

    public LottoNumbers toLottoNumbers(String textNumber) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String number : textNumber.split(SPLIT_DELIMITER)) {
            lottoNumbers.add(new LottoNumber(Integer.parseInt(number.trim())));
        }
        return new LottoNumbers(lottoNumbers);
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
