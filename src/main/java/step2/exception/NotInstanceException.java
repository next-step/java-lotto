package step2.exception;

public class SingletonConstructorException extends RuntimeException {
    private static final String DO_NOT_ACCESS_CONSTRUCTOR = "생성자에 접근할 수 없는 싱글톤 클래스입니다.";

    public SingletonConstructorException() {
        super(DO_NOT_ACCESS_CONSTRUCTOR);
    }
}
