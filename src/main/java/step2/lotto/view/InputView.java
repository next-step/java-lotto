package step2.lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";

    public int inputMoney() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
        return scanner.nextInt();
    }

}
