package my.project.lotto.view;


import my.project.utils.Scan;

import java.util.Scanner;

/**
 * Created : 2020-11-02 오전 8:25.
 * Developer : Seo.
 */
public class InputView {
    public static final String ENTER_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String ENTER_LAST_WINNIG_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";

    public static int getMoney() {
        Scanner scanner = Scan.getInstance();
        System.out.println(ENTER_AMOUNT);
        return scanner.nextInt();
    }

    public static String getWinningNumbers() {
        Scanner scanner = Scan.getInstance();
        System.out.println(ENTER_LAST_WINNIG_NUMBERS);
        return scanner.next();
    }

    public static int getBonusNumber() {
        Scanner scanner = Scan.getInstance();
        System.out.println(ENTER_BONUS_NUMBER);
        return scanner.nextInt();
    }

    private InputView() {
    }
}
