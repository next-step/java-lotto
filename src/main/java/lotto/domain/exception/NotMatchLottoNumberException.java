package lotto.domain.exception;

public class NotMatchLottoNumberException extends RuntimeException{

    private static final String MESSAGE = "당첨번호와 복권번호를 먼저 확인해주세요";

    public NotMatchLottoNumberException(){
        super(MESSAGE);
    }
}
