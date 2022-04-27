package Lotto.Exception;

import StringCalculator.Exception.CustomException;

public class InvalidMoneyForLottoException extends CustomException {

    public InvalidMoneyForLottoException(String message) {
        super(message);
    }

    public InvalidMoneyForLottoException() {
        super("로또는 1000원 단위로만 구입할 수 있습니다.");
    }
}