package step2_2;

import static step2_2.InputUtil.readInt;
import static step2_2.InputUtil.readNumbers;

import java.util.List;

public class InputView {

    private static final String MONEY_INPUT_MESSAGE = "구입금액을 입력해주세요";
    private static final String LOTTO_NUMBER_INPUT_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView() {
    }

    public static Money readMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);
        try {
            return new Money(readInt());
        } catch (InvalidMoneyInputException e) {
            System.out.println(e.getMessage());
            return readMoney();
        }
    }

    public static List<Integer> readLottoNumbers() {
        System.out.println(LOTTO_NUMBER_INPUT_MESSAGE);
        return readNumbers();
    }
}
