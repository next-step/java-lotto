package lotto.view;

import lotto.utils.ValidationUtil;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_MSG = "구입금액을 입력해주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int payLotto() {
        System.out.println(INPUT_MSG);
        String number = scanner.next();
        ValidationUtil.checkNumber(number);

        return Integer.parseInt(number);
    }


}
