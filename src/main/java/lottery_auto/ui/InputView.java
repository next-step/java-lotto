package lottery_auto.ui;

import java.math.BigDecimal;
import java.util.Scanner;

public class InputView {

    private static final String LOTTERY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner LOTTERY_SCANNER = new Scanner(System.in);

    public static BigDecimal inputAmount() {
        System.out.println(LOTTERY_MESSAGE);
        String amount = LOTTERY_SCANNER.nextLine();
        return new BigDecimal(amount);
    }

    public static String inputWinningNumber() {
        System.out.println(WINNING_NUMBER_MESSAGE);
        return LOTTERY_SCANNER.nextLine();
    }

}
