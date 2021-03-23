package lotto.view;

import lotto.domain.WinNumbers;
import lotto.util.InputViewUtil;
import lotto.util.StringUtil;

public class InputView {
    private int payMoney;
    private WinNumbers winNumbers;

    public void inputPayMoney(String message) {
        this.payMoney = InputViewUtil.scannerInt(message);
    }

    public void inputHitNumbers(String message) {
        String numbers = InputViewUtil.scannerString(message);
        this.winNumbers = new WinNumbers(splitNumbers(numbers));
    }

    private String[] splitNumbers(String numbers) {
        return StringUtil.split(",", numbers);
    }

    public int getPayMoney() {
        return payMoney;
    }

    public WinNumbers getWinNumbers() {
        return winNumbers;
    }
}
