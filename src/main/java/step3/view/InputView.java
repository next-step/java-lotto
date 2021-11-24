package step3.view;

import static step3.view.InputUtil.readInt;

import step3.model.Lotto;
import step3.model.Money;

public class InputView {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해주세요";
    private static final String LOTTO_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해주세요";

    public static Money readMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        try {
            return new Money(readInt());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readMoney();
        }
    }

    public static Lotto readLotto() {
        System.out.println(LOTTO_INPUT_MESSAGE);
        try {
            return new Lotto(InputUtil.readIntList());
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return readLotto();
        }
    }

    private InputView() {
    }
}
