package exception;

public class InvalidLottoNumbersException extends Exception {
    public InvalidLottoNumbersException(){
    }

    public InvalidLottoNumbersException(String message){
        super(message);
    }
}
