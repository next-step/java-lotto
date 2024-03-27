package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final String WINNING_NUMBERS_SEPARATOR = ", ";

    public static int inputPurchaseAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static String[] inputWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine().split(WINNING_NUMBERS_SEPARATOR);
    }


}
