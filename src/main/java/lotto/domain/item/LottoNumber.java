package lotto.domain.item;

import lotto.exception.ValidLottoException;

public class LottoNumber implements Cloneable {

    private static final int LOTTO_MIN_NUMBER_SIZE = 1;
    private static final int LOTTO_MAX_NUMBER_SIZE = 45;

    private int number;

    public LottoNumber(int number) {
        validateNumberRange(number);
        this.number = number;
    }

    private void validateNumberRange(int numbers) {
        if (numbers < LOTTO_MIN_NUMBER_SIZE || numbers > LOTTO_MAX_NUMBER_SIZE) {
            throw new ValidLottoException("번호는 1~ 45 사이의 정수만 가능 합니다.");
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
