package lotto.exception;

public class InvalidLottoNumberException extends RuntimeException{
    private static final String INVALID_LOTTO_NUMBER_MESSAGE = "로또 번호는 1~45사이의 수 입니다";
    public InvalidLottoNumberException(){
        super(INVALID_LOTTO_NUMBER_MESSAGE);
    }
}
