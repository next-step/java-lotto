package lotto.exception;


public class DuplicateLottoNumberException extends IllegalArgumentException{

    private static final String ERROR_MESSAGE = "보너스 번호는 로또번호와 중복될 수 없습니다. (입력한 보너스 번호: %d)";

    public DuplicateLottoNumberException(int bonus) {
        super(String.format(ERROR_MESSAGE, bonus));
    }
}
