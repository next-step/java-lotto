package lotto.model;

import lotto.util.LottoNumberUtil;

import java.util.ArrayList;
import java.util.List;

public class LottoNumbers {


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
        this.lottoNumbers = new ArrayList<>(LottoNumberPicker.pickNumber());
        return this;
    }


    public List<LottoNumber> selectedNumber() {
        return this.lottoNumbers;
    }
}
