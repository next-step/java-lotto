package lotto.exception;


import lotto.model.Number;

public class DuplicateLottoNumberException extends IllegalArgumentException{

    private static final String ERROR_MESSAGE = "보너스 번호는 로또번호와 중복될 수 없습니다. (입력한 보너스 번호: %s)";

    public DuplicateLottoNumberException(Number bonus) {
        super(String.format(ERROR_MESSAGE, bonus));
    }
}
