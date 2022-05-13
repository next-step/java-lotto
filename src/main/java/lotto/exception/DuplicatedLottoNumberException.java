package lotto.exception;

public class DuplicatedLottoNumberException extends RuntimeException{
    private static final String DUPLICATED_LOTTO_NUMBER_MESSAGE = "중복되는 숫자가 있습니다.";
    public DuplicatedLottoNumberException(){
        super(DUPLICATED_LOTTO_NUMBER_MESSAGE);
    }
}
