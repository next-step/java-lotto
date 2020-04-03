package lotto.domain.lotto;

import lotto.exception.ValidLottoException;

import java.util.List;
import java.util.Objects;

public class Lotto {

    private static final String NULL_PARAM_ERROR_MESSAGE = "매개변수:null";
    protected final LottoNumbers numbers;

    public Lotto(LottoNumbers numbers) {
        if (numbers == null) {
            throw new ValidLottoException(NULL_PARAM_ERROR_MESSAGE);
        }
        this.numbers = new LottoNumbers(numbers);
    }

    public Lotto(List<LottoNumber> numbers) {
        if (numbers == null) {
            throw new ValidLottoException(NULL_PARAM_ERROR_MESSAGE);
        }
        this.numbers = new LottoNumbers(numbers);
    }

    public LottoNumbers getNumbers() {
        return numbers;
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
