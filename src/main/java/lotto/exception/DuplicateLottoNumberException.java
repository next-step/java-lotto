package lotto.exception;

public class DuplicateLottoNumberException extends IllegalArgumentException{

    private static final String ERROR_MESSAGE = "로또 번호는 중복될 수 없습니다. (입력한 로또번호: %s 보너스 번호: %d)";

    public DuplicateLottoNumberException(String numbers, int bonus) {
        super(String.format(ERROR_MESSAGE, numbers, bonus));
    }
}
