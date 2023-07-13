package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    public static final String NUMBER_SPLIT_DELIMITER = ", ";

    private InputView() {
    }

    public static long readMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            final long money = Long.parseLong(scanner.nextLine());
            validatePositive(money);
            System.out.println();

            return money;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("구입금액은 정수여야 합니다.");
        }
    }

    public static long readManualPurchaseCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");

        try {
            final long count = Long.parseLong(scanner.nextLine());
            validateNonNegative(count);
            System.out.println();

            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 정수여야 합니다.");
        }
    }

    public static void printPromptMessageForManualPurchaseLottoNumbers() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

    public static void printPromptMessageForWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
    }

    public static List<Integer> readLottoNumbers() {
        try {
            final String[] numbers = scanner.nextLine().split(NUMBER_SPLIT_DELIMITER);

            return Arrays.stream(numbers)
                .map(Integer::valueOf)
                .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                "로또번호는 `" + NUMBER_SPLIT_DELIMITER + "`로 구분하여 정수로 입력해야 합니다.");
        }
    }

    public static int readLottoNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        try {
            final int number = Integer.parseInt(scanner.nextLine());
            System.out.println();

            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("로또번호는 정수여야 합니다.");
        }
    }

    private static void validatePositive(final long money) {
        if (money <= 0) {
            throw new IllegalArgumentException("구입금액은 양의 정수여야 합니다.");
        }
    }

    private static void validateNonNegative(final long count) {
        if (count < 0) {
            throw new IllegalArgumentException("수동으로 구매할 로또 수는 음수일 수 없습니다.");
        }
    }
}
