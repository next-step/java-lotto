package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final int MINIMUM_MONEY = 1000;
    private static final int MINIMUM_BALL_NUMBER = 1;
    private static final int MAXIMUM_BALL_NUMBER = 45;
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            final int money = parseToInt(SCANNER.nextLine());
            validateMinimumMoney(money);
            return money;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    private static int parseToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해주세요.");
        }
    }

    private static void validateMinimumMoney(int money) {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException(
                "[ERROR] " + MINIMUM_MONEY + "원에 1장입니다. " + MINIMUM_MONEY + "보다 큰 값을 입력해주세요.");
        }
    }

    public static List<Integer> inputLastWinningNumbers() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            final String lastWinningLotto = SCANNER.nextLine();
            final List<Integer> winningNumbers = Arrays.stream(lastWinningLotto.split(","))
                .map(number -> {
                    final int winningNumber = parseToInt(number.trim());
                    validateRange(winningNumber);
                    return winningNumber;
                }).collect(Collectors.toList());
            validateDuplicateWinning(winningNumbers);
            validateSize(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLastWinningNumbers();
        }
    }

    private static void validateDuplicateWinning(List<Integer> winningNumbers) {
        final List<Integer> deleteDuplicateNumbers = winningNumbers.stream()
            .distinct().collect(Collectors.toList());
        if (winningNumbers.size() != deleteDuplicateNumbers.size()) {
            throw new IllegalArgumentException("[ERROR] 중복되는 숫자가 있습니다.");
        }
    }

    private static void validateSize(List<Integer> winningNumbers) {
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호는 6개여야 합니다.");
        }
    }

    public static Integer inputBonusNumber(List<Integer> winningNumbers) {
        try {
            System.out.println("보너스 볼을 입력해주세요.");
            final int bonusNumber = parseToInt(SCANNER.nextLine());
            validateRange(bonusNumber);
            validateDuplicateBonus(bonusNumber, winningNumbers);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputBonusNumber(winningNumbers);
        }
    }

    private static void validateRange(int bonusNumber) {
        if (bonusNumber < MINIMUM_BALL_NUMBER || bonusNumber > MAXIMUM_BALL_NUMBER) {
            throw new IllegalArgumentException("[ERROR] 1부터 45까지의 숫자만 입력해주세요.");
        }
    }

    private static void validateDuplicateBonus(int bonusNumber, List<Integer> winningNumbers) {
        if (winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호와 중복된 값입니다. 다시 입력해주세요.");
        }
    }
}
