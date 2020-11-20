package study.lotto.core;

public class LottoNumberFormatException extends RuntimeException{

    private static final String defaultMessage =
            "LottoNumber는 1 - 45사이의 숫자 또는 문자열만 입력 가능합니다.";

    public LottoNumberFormatException(int value) {
        super(String.format("%s (입력값 = %d)", defaultMessage, value));
    }

    public LottoNumberFormatException(String value) {
        super(String.format("%s (입력값 = %s)", defaultMessage, value));
    }

}
