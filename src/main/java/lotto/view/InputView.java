package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String MESSAGE_OF_INVERST_MONEY = "구입금액을 입력해 주세요.";
    private static final String MESSAGE_OF_WINNING_NUMBER = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String MESSAGE_OF_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String SEPARATOR = ",";
    private static final String MESSAGE_OF_MANUAL_TICKET_COUNT = "\n수동으로 구매할 로또 수를 입력해 주세요.";

    private static Scanner scanner = new Scanner(System.in);

    public static int inputInvestMoney() {
        System.out.println(MESSAGE_OF_INVERST_MONEY);
        int money = scanner.nextInt();
        scanner.nextLine();

        return money;
    }

    public static List<Integer> inputManualNumbers() {
        return inputNumbers();
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println(MESSAGE_OF_WINNING_NUMBER);
        return inputNumbers();
    }

    private static List<Integer> inputNumbers() {
        String numbers = scanner.nextLine();

        return Arrays.stream(numbers.split(SEPARATOR))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        System.out.println(MESSAGE_OF_BONUS_NUMBER);
        int bonusNumber = scanner.nextInt();
        scanner.nextLine();

        return bonusNumber;
    }

    public static int inputCountOfManualTicket() {
        System.out.println(MESSAGE_OF_MANUAL_TICKET_COUNT);
        int count = scanner.nextInt();
        scanner.nextLine();

        return count;
    }
}
