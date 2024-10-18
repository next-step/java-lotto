package lotto.exception;

public class NumberOfLottoNumberException extends IllegalArgumentException {

    public static final String PREFIX = "현재 로또 번호 개수 : ";
    public static final String SUFFIX = " 하나의 로또의 로또 번호 개수는 6개여야 함";

    public NumberOfLottoNumberException(String message) {
        super(PREFIX +message+ SUFFIX);
    }
}
