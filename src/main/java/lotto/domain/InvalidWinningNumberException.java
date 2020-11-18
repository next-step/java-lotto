package lotto.domain;

import java.text.MessageFormat;

public class InvalidWinningNumberException extends RuntimeException{

    private final static String messagePattern = "당첨번호는 , 로 구분하여 1~45 사이 숫자로 6개를 입력해야 합니다. ( 입력된 당첨번호: {0} )";

    public InvalidWinningNumberException(String number){
        super(MessageFormat.format(messagePattern, number));
    }

    public InvalidWinningNumberException(String number, Throwable cause) {
        super(MessageFormat.format(messagePattern, number), cause);
    }
}
