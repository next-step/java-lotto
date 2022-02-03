package lotto.view;

import java.util.Scanner;

public class InputView {

    Scanner scanner = new Scanner(System.in);

    final String PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    final String WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";

    private String getInputString(String message) {
        System.out.println(message);
        return scanner.nextLine();
    }

    public final String getPrice() {
        return getInputString(PRICE_MESSAGE);
    }

    public final String getWinNumber() {
        return getInputString(WIN_NUMBER_MESSAGE);
    }

    public final String getBonusNumber() {
        return getInputString(BONUS_NUMBER_MESSAGE);
    }


}
