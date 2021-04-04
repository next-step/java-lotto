package lotto.exception;

public class LottoNumbersSizeOverException extends RuntimeException {

    public LottoNumbersSizeOverException(){
        super("Numbers can contain 6 numbers.");
    }

    public LottoNumbersSizeOverException(String s) {
        super(s);
    }
}