package step1;

public class NegativeException extends RuntimeException {
    public NegativeException() {
        super("0보다 작은 값을 입력할 수 없습니다.");
    }
}
