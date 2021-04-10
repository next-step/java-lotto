package lotto.exception;

public class LottoNumbersSizeException extends RuntimeException {

    public LottoNumbersSizeException(){
        super("Numbers can contain 6 numbers.");
    }

    public LottoNumbersSizeException(String s) {
        super(s);
    }
}