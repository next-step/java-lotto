package lotto.view;

import lotto.util.UserInputHandler;

public class InputView {
    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return UserInputHandler.scanMoney();
    }

    public static String getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return UserInputHandler.scan();
    }
}
