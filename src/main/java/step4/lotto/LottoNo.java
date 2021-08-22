package step4.lotto;

import step4.lotto.exception.ExceptionMessage;
import step4.lotto.exception.InvalidLottoNumberException;

import java.util.Objects;
import java.util.function.Function;

public class LottoNo {

    private static final int LOTTO_NUMBER_MIN_BOUND = 1;
    private static final int LOTTO_NUMBER_MAX_BOUND = 45;

    private final int number;

    public LottoNo(int number) {
        Function<Integer, Boolean> boundaryValidateFunction = value -> value <= LOTTO_NUMBER_MAX_BOUND && value >= LOTTO_NUMBER_MIN_BOUND;
        boolean outOfBoundary = !boundaryValidateFunction.apply(number);

        if (outOfBoundary)
            throw new InvalidLottoNumberException(ExceptionMessage.NUMBER_OUT_OF_BOUNDARY);

        this.number = number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof LottoNo))
            return false;

        LottoNo lottoNo = (LottoNo) obj;
        return this.number == lottoNo.number;
    }

    @Override
    public String toString() {
        return number + "";
    }
}
