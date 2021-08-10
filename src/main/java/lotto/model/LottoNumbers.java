package lotto.model;

import lotto.util.LottoNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_SIZE = 6;
    private static final String SPLIT_TOKEN = ",";

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers() {
        this.lottoNumbers = new ArrayList<>();
    }

    public LottoNumbers(String numbers) {
        this.lottoNumbers = new ArrayList<>();
        String[] numbersArr = numbers.split(SPLIT_TOKEN);
        for (String number : numbersArr) {
            LottoNumber lottoNumber = LottoNumberPicker.pickNumber(Integer.parseInt(number));
            LottoNumberUtil.containsNumber(lottoNumbers, lottoNumber);
            lottoNumbers.add(lottoNumber);
        }
    }

    public LottoNumbers generateNumbers() {
        while (this.lottoNumbers.size() < LOTTO_NUMBER_SIZE) {
            setNumber(LottoNumberPicker.pickNumber());
        }
        return this;
    }

    private void setNumber(LottoNumber lottoNumber) {
        if (!this.lottoNumbers.contains(lottoNumber)) {
            this.lottoNumbers.add(lottoNumber);
        }
    }

    public List<LottoNumber> selectedNumber() {
        return this.lottoNumbers;
    }
}
