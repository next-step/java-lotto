package lotto.view.input;

import java.util.Scanner;

public class PaymentAmountInputView {
    private final UserInterface userInterface;

    public PaymentAmountInputView(UserInterface userInterface) {
        this.userInterface = userInterface;
    }

    public int getPaymentAmount() {
        userInterface.show("구입금액을 입력해주세요.");
        return userInterface.getInt();
    }
}
