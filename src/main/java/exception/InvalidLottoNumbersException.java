package exception;

public class InvalidLottoNumbersException extends RuntimeException {
    public InvalidLottoNumbersException(){
    }

    public InvalidLottoNumbersException(String message){
        super(message);
    }
}
