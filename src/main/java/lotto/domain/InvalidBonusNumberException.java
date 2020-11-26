package lotto.domain;

import java.text.MessageFormat;

public class InvalidBonusNumberException extends InvalidWinningNumberException{

    private final static String messagePattern = "보너스 번호는 당첨번호 이외에 1~45 사이 숫자만 사용가능합니다 ( 입력한 보너스번호 : {0} )";

    public InvalidBonusNumberException(int bonusNumber) {
        super(MessageFormat.format(messagePattern, bonusNumber));
    }

    public InvalidBonusNumberException(int bonusNumber, Throwable cause) {
        super(MessageFormat.format(messagePattern, bonusNumber), cause);
    }
}
