package lotto.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static String GET_PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    private static String GET_WINNING_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView() {

    }

    public static int getPurchaseAmount() {
        System.out.println(GET_PURCHASE_AMOUNT_QUESTION);
        return scanner.nextInt();
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(GET_WINNING_NUMBER_QUESTION);
        scanner.nextLine();
        String winningNumberString = scanner.nextLine();

        return Arrays.stream(winningNumberString.split(", "))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
