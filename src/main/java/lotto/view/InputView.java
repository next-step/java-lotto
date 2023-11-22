package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String QUESTION_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String QUESTION_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";

    public static int inputMoney() {
        System.out.println(QUESTION_PURCHASE_AMOUNT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static String inputWinningNumbers() {
        System.out.println();
        System.out.println(QUESTION_WINNING_NUMBERS);
        return scanner.nextLine();
    }
}
