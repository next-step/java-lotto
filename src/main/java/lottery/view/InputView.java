package lottery.view;

import lottery.util.ConsoleInteractiveInputUtils;

import java.util.List;

public class InputView {

    private static final String BASIC_DELIMITER = ",";

    public int receivePurchaseAmount() {
        return ConsoleInteractiveInputUtils.getInt("구입 금액을 입력해주세요.");
    }

    public List<Integer> receiveWinningNumbers() {
        return ConsoleInteractiveInputUtils.getListOfInteger("지난 주 당첨 번호를 입력해 주세요.", BASIC_DELIMITER);
    }

}
