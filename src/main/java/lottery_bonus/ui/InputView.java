package lottery_bonus.ui;

import java.util.Scanner;

public class InputView {

    private static final String LOTTERY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final Scanner LOTTERY_SCANNER = new Scanner(System.in);

    public static String inputAmount() {
        System.out.println(LOTTERY_MESSAGE);
        return LOTTERY_SCANNER.nextLine();
    }
}
