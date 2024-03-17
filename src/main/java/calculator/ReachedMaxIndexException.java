package calculator;

public class ReachedMaxIndexException extends RuntimeException {

    public ReachedMaxIndexException(String message) {
        super(message);
    }

    public ReachedMaxIndexException() {
        this("마지막 요소에 도달했습니다.");
    }
}
