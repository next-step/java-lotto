package lotto.view;

import java.util.List;
import java.util.Scanner;

public class InputScanner {
    private static final String REQUEST_FOR_MONEY_INPUT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_FOR_WINNING_LOTTO_INPUT = "지난 주 당첨번호를 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String getPurchasePrice() {
        System.out.println(REQUEST_FOR_MONEY_INPUT);
        return scanner.nextLine();
    }

    public static List<Integer> getWinningLotto() {
        System.out.println(REQUEST_FOR_WINNING_LOTTO_INPUT);
        return StringConverter.convertStringToNumbers(scanner.nextLine());
    }
}