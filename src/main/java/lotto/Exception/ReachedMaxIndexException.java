package lotto.Exception;

public class ReachedMaxIndexException extends RuntimeException {

    public ReachedMaxIndexException() {
        this("최대 인덱스에 도달했습니다.");
    }

    public ReachedMaxIndexException(String message) {
        super(message);
    }
}
