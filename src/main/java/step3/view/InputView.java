package step3.view;

import step3.model.Money;

public class InputView {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해주세요";

    public static Money readMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        try {
            return new Money(InputUtil.readInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readMoney();
        }
    }

    private InputView() {
    }
}
