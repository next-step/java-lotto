package lotto.domain;

import lotto.exception.OutOfLottoNumberSizeException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LottoNumbers {
    public static final int LOTTO_NUMBER_MAX_SIZE = 6;
    private static final String LOTTO_NUMBER_DELIMITER = ", ";

    private List<LottoNumber> lottoNumbers;

    public LottoNumbers(final String input) {
        this(newInstanceFromInput(input));
    }
    public LottoNumbers(final List<LottoNumber> lottoNumbers) {
        checkLottoNumberSize(lottoNumbers);
        Collections.sort(lottoNumbers);
        this.lottoNumbers = Collections.unmodifiableList(lottoNumbers);
    }

    private void checkLottoNumberSize(final List<LottoNumber> lottoNumbers) {
        if (lottoNumbers != null && lottoNumbers.size() != LOTTO_NUMBER_MAX_SIZE) {
            throw new OutOfLottoNumberSizeException();
        }
    }

    private static List<LottoNumber> newInstanceFromInput(final String input) {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (String letter : input.split(LOTTO_NUMBER_DELIMITER)) {
            LottoNumber lottoNumber = LottoNumber.valueOf(Integer.valueOf(letter));
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        final LottoNumbers that = (LottoNumbers) o;
        return Objects.equals(lottoNumbers, that.lottoNumbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoNumbers);
    }
}
