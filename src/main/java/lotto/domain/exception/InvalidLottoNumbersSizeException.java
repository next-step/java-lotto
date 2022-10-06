package lotto.domain.exception;

public class InvalidLottoNumbersSizeException extends RuntimeException {

    public InvalidLottoNumbersSizeException(int ticketSize) {
        super("로또 번호 수는 " + ticketSize + "개입니다.");
    }

}
