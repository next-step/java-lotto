package domain.lotto.view;

import java.util.Scanner;

public class InputView {
    public static final String BUYING_PRICE_QUESTION = "구입금액을 입력해 주세요.";
    public static final String WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static int getBuyingPrice() {
        System.out.println(BUYING_PRICE_QUESTION);
        return scanner.nextInt();
    }

    public static String getWinningNumber() {
        scanner.nextLine();
        System.out.println(WINNING_NUMBER_QUESTION);
        return scanner.nextLine();
    }
}
