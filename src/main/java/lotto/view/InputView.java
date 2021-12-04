package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_MESSAGE_MONEY_FOR_LOTTO = "구입 금액을 입력해 주세요.";

    public int showMessageAndGetMoneyInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(INPUT_MESSAGE_MONEY_FOR_LOTTO);

        return scanner.nextInt();
    }
}
