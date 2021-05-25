package lotto.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;

import static lotto.model.LottoNumber.LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_COUNT = 6;
    private final List<LottoNumber> lottoNumbers;

    public LottoNumbers(List<LottoNumber> numbers) {
        normalSize(numbers);
        this.lottoNumbers = numbers;
    }

    private void normalSize(List<LottoNumber> lottoNumbers) {
        if (!(new HashSet<>(lottoNumbers).size() == LOTTO_NUMBER_COUNT)) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_BOUND_MESSAGE);
        }
    }

    public String printInfo(){
        return ((List<LottoNumber>) new ArrayList<>(lottoNumbers)).toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}

