package lotto.view;

import lotto.utils.StringUtils;
import lotto.utils.ValidationUtil;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_MSG = "구입금액을 입력해주세요.";
    public static final String INPUT_LAST_LOTTO_MSG = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int payLotto() {
        System.out.println(INPUT_MSG);
        String number = scanner.next();
        ValidationUtil.checkNumber(number);

        return Integer.parseInt(number);
    }

    public static String[] enterLastNumber() {
        System.out.println(INPUT_LAST_LOTTO_MSG);
        String number = scanner.next();
        return StringUtils.split(number);
    }
}
