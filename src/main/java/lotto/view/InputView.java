package lotto.view;

import java.util.Scanner;

public class InputView {
    private final static String PRINT_REQUIRE_PRICE = "구입금액을 입력해 주세요.";
    private final static String PRINT_REQUIRE_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    private final static String PRINT_REQUIRE_BONUS = "보너스 볼을 입력해 주세요.";

    public static int printRequirePrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PRINT_REQUIRE_PRICE);

        return scanner.nextInt();
    }

    public static String printRequireWinningNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println(PRINT_REQUIRE_WINNING_NUMBERS);

        return scanner.nextLine();
    }

    public static int printRequireBonusBall() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PRINT_REQUIRE_BONUS);

        return scanner.nextInt();
    }
}
