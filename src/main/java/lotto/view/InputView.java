package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String LOTTO_MONEY_MESSAGE = "구입금액을 입력해 주세요.";

    private InputView() {
    }

    public static String scanLottoMoney() {
        System.out.println(LOTTO_MONEY_MESSAGE);

        return scanner.nextLine();
    }
}
