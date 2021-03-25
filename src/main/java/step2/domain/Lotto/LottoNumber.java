package step2.domain.Lotto;

import step2.exception.InvalidNumberInputException;

public final class LottoNumber {

    private static final int ZERO = 0;

    private final Integer lottoNumber;

    private LottoNumber(int lottoNumber){
        this(Integer.valueOf(lottoNumber));
    }

    private LottoNumber(Integer lottoNumber){
        if(isOutOfBounds(lottoNumber)) {
            throw new InvalidNumberInputException();
        }
        this.lottoNumber = lottoNumber;
    }

    public static final LottoNumber valueOf(int lottoNumber) {
        return new LottoNumber(lottoNumber);
    }

    private final boolean isOutOfBounds(Integer inputMoney) {
        return inputMoney < ZERO;
    }

}
