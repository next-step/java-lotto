package lotto.view;

import java.util.Scanner;

public class InputView {
    public static final String INPUT_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMbERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    private String price;
    private String winningNumbers;

    public void inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        price = SCANNER.nextLine();
    }

    public void inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMbERS_MESSAGE);
        winningNumbers = SCANNER.nextLine();
        System.out.println();
    }

    public String getPrice() {
        return price;
    }

    public String getWinningNumbers() {
        return winningNumbers;
    }
}
