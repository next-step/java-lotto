package exception;

public class ExceptionMessage {
    private ExceptionMessage() {}

    public static final String LESS_THEN_1_EXCEPTION_MESSAGE = "최소 금액은 0원 이상입니다.";
    public static final String INVALID_LOTTO_NUMBER_EXCEPTION_MESSAGE = "유효한 로또 숫자 범위가 아닙니다.";
    public static final String DUPLICATED_LOTTO_NUMBER_EXCEPTION_MESSAGE = "중복된 로또 숫자가 존재합니다.";
    public static final String LOTTO_SIZE_EXCEPTION_MESSAGE = "로또 숫자는 6개 이어야 합니다.";
}
