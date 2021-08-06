package lottos.domain.exceptions;

public class LottoSizeIncorrectException extends RuntimeException {

    public LottoSizeIncorrectException() {
        super("로또는 6개 입니다.");
    }
}
