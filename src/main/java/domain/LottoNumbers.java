package domain;

import exception.InvalidLottoNumbersException;
import exception.NumberNotInRangeException;

import java.util.List;
import java.util.stream.Stream;

public class LottoNumbers {
    private List<Integer> lottoNumbers;

    public static final int LOTTO_NUMBERS_MIN = 1;
    public static final int LOTTO_NUMBERS_MAX = 45;
    public static final int LOTTO_NUMBERS_SIZE = 6;

    public LottoNumbers(List<Integer> lottoNumbers) throws Exception {
        if(lottoNumbers.stream().distinct().count() != LOTTO_NUMBERS_SIZE) {
            throw new InvalidLottoNumbersException();
        }

        if(lottoNumbers.stream().anyMatch(i -> i < LOTTO_NUMBERS_MIN || i > LOTTO_NUMBERS_MAX)) {
            throw new NumberNotInRangeException();
        }

        this.lottoNumbers = lottoNumbers;
    }

    public Stream stream() {
        return lottoNumbers.stream();
    }

    public boolean contains(Object o) {
        return lottoNumbers.contains(o);
    }

    @Override
    public String toString() {
        return lottoNumbers.toString();
    }
}
