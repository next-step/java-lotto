package lottos.domain.exceptions;

public class LottoDuplicationNumberException extends RuntimeException {

    public LottoDuplicationNumberException() {
        super("로또는 중복된 숫자를 가질 수 없습니다.");
    }

}
