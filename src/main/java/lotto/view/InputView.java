package lotto.view;

import lotto.utility.InputUtil;


public class InputView {

    private final InputUtil inputUtil = new InputUtil();

    public long purchaseAmount() {

        return inputUtil.inputToLong("구입금액을 입력해 주세요.");
    }

    public String inputWinningNumber() {

        return inputUtil.inputToLine("지난 주 당첨 번호를 입력해주세요.");
    }

    public int inputBonusNumber() {

        return inputUtil.inputToInt("보너스 볼을 입력해 주세요.");
    }
}
