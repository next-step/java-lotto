package lotto;

import lotto.domain.Message;

public class CustomIllegalArgumentException extends RuntimeException {

    public CustomIllegalArgumentException(Message message) {
        super(message.getText());
    }

    public CustomIllegalArgumentException(Message message, Object arg1) {
        super(String.format(message.getText(), arg1));
    }

    public CustomIllegalArgumentException(Message message, Object arg1, Object arg2) {
        super(String.format(message.getText(), arg1, arg2));
    }
}
