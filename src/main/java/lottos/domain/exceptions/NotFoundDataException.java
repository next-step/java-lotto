package lottos.domain.exceptions;

public class NotFoundDataException extends RuntimeException {

    public NotFoundDataException() {
        super("데이터를 찾을 수 없습니다.");
    }
}
