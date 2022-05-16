package lotto.exceptions;

public class DuplicatedNumbersException extends IllegalArgumentException {

    public static final String DUPLICATED_NUMBERS = "중복된 로또 번호를 입력할 수 없습니다.";
    public DuplicatedNumbersException() {
        super(DUPLICATED_NUMBERS);
    }
}
