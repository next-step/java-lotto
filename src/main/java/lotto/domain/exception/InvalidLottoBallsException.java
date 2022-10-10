package lotto.domain.exception;

public class InvalidLottoBallsException extends RuntimeException {

    public InvalidLottoBallsException(int size) {
        super("로또볼은 " + size + "개 넣을 수 있으며 중복이 있거나 null 은 허용하지 않습니다.");
    }
}
