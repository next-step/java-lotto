package lotto.view;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String WINNING_NUMBERS_FORMAT = "^\\d{1,2}(,\\s\\d{1,2}){5}$";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        int purchaseAmount = 0;

        try {
            System.out.println("구입금액을 입력해 주세요.");
            purchaseAmount = scanner.nextInt();
            scanner.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요");
        }
        return purchaseAmount;
    }

    public static String inputLastWeekWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String lastWeekWinningNumbers = scanner.nextLine();

        System.out.println();

        if (lastWeekWinningNumbers.matches(WINNING_NUMBERS_FORMAT)) {
            return lastWeekWinningNumbers;
        }

        throw new IllegalArgumentException("잘못된 입력형식입니다. 1, 2, 3, 4, 5, 6과 같은 형태로 입력해주세요");
    }
}
