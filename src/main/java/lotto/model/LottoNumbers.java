package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {

    private static final int LOTTO_NUMBER_SIZE = 6;

    private List<LottoNumber> lottoNumber;

    public LottoNumbers() {
        this.lottoNumber = new ArrayList<>();
    }

    public LottoNumbers(String numbers) {
        String[] numbersArr = numbers.split(",");
        for (String number : numbersArr) {
            lottoNumber.add(LottoNumberPicker.pickNumber(Integer.parseInt(number)));
        }
    }

    public LottoNumbers generateNumbers() {
        while (this.lottoNumber.size() < LOTTO_NUMBER_SIZE) {
            setNumber(LottoNumberPicker.pickNumber());
        }
        return this;
    }

    private void setNumber(LottoNumber lottoNumber) {
        if (!this.lottoNumber.contains(lottoNumber)) {
            this.lottoNumber.add(lottoNumber);
        }
    }

    public List<LottoNumber> selectedNumber() {
        return this.lottoNumber;
    }
}
