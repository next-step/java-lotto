package lotto.domain;

import lotto.domain.wrapper.LottoNumber;

import java.util.*;

import static lotto.domain.LottoGameOptions.*;

public class Lotto {
    private LottoNumbers lottoNumbers;

    public Lotto(LottoNumbers lottoNumbers) {
        this.lottoNumbers = lottoNumbers;

        if (this.lottoNumbers.sizeIsNotSameWith(LOTTO_NUMBER_COUNT)) {
            throw new IllegalArgumentException();
        }
    }

    public Lotto(List<Integer> numbers) {
        this(new LottoNumbers(numbers));
    }

    public String lottoNumberString() {
        return lottoNumbers.formattedString();
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    public int numbers(int index) {
        return lottoNumbers.get(index);
    }

    public List<LottoNumber> numbers() {
        return lottoNumbers.lottoNumbers();
    }
}
