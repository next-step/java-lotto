package lotto;

import exception.CustomException;
import lotto.exception.LottoErrorCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Lotto {

    public static final int SELECT_SIZE = 6;

    private final List<LottoNumber> numbers;

    private Lotto(List<LottoNumber> numbers) {
        this.numbers = numbers;
    }

    public static Lotto generate() {
        List<LottoNumber> lottoNumbersRange = LottoNumber.getLottoNumbersRange();
        Collections.shuffle(lottoNumbersRange);
        return new Lotto(lottoNumbersRange.subList(0, SELECT_SIZE));
    }

    public static Lotto from(Lotto lotto) {
        return new Lotto(lotto.numbers);
    }

    public static Lotto from(List<LottoNumber> lottoNumbers) {
        checkLottoSize(lottoNumbers.size());
        return new Lotto(lottoNumbers);
    }

    private static void checkLottoSize(int size) {
        if (size != SELECT_SIZE) {
            throw new CustomException(LottoErrorCode.LOTTO_SIZE_BAD_REQUEST);
        }
    }

    public List<LottoNumber> getLotto() {
        List<LottoNumber> result = new ArrayList<>();
        for (LottoNumber lotto : numbers) {
            result.add(LottoNumber.from(lotto));
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return Objects.equals(numbers, lotto.numbers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numbers);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
