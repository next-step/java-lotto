package calculator.exception;

public class InvalidOperatorException extends IllegalArgumentException{

    public static final String errorMessage = "는 잘못된 연산기호 입니다";

    public InvalidOperatorException(String invalidOperator){
        super(invalidOperator+ errorMessage);
    }
}
