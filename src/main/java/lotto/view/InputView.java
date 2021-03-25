package lotto.view;

import lotto.domain.WinNumbers;
import lotto.util.InputViewUtil;
import lotto.util.StringUtil;

public class InputView {
    private int payMoney;
    private WinNumbers winNumbers;

    public void inputPayMoney() {
        this.payMoney = InputViewUtil.scannerInt("구입금액을 입력해 주세요.");
    }

    public void inputHitNumbers() {
        String numbers = InputViewUtil.scannerString("지난 주 당첨 번호를 입력해 주세요.");
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
