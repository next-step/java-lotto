package calculator;

public class DividedNumberException extends RuntimeException {

    private static final String DIVIDED_NUMBER_MESSAGE = "나눗셈의 결과는 정수로 떨어진 값만 가능합니다.";

    public DividedNumberException() {
        super(DIVIDED_NUMBER_MESSAGE);
    }

}
