package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_BUYING_MONEY = "구입금액을 입력해주세요.";

    private InputView() {
        throw new AssertionError();
    }

    public static int inputBuyingMoney() {
        System.out.println(INPUT_BUYING_MONEY);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalStateException("잘못된 입력입니다. 올바른 구입 금액(숫자)를 입력해주세요.");
        }
    }

}
