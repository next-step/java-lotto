package step2.exception;

public class IllegalLottoResultCount extends RuntimeException{

    public IllegalLottoResultCount() {
        super();
    }

    public IllegalLottoResultCount(String message) {
        super(message);
    }
}
