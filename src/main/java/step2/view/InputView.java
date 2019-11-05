package step2.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final int MINIMUM_MONEY = 1000;

    private static final Scanner scanner = new Scanner(System.in);

    public static Integer inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        int money = Integer.parseInt(scanner.nextLine());
        validateInput(money);

        return money;
    }

    private static void validateInput(int money) {
        if (money < MINIMUM_MONEY) {
            throw new IllegalArgumentException(money + "는 최소금액보다 적습니다.");
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Arrays.stream(splitNumbers(scanner.nextLine()))
                .map(Integer::parseInt)
                .collect(toList());
    }

    private static String[] splitNumbers(String input) {
        return input.replace(" ", "")
                .split(",");
    }

    public static Integer inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = Integer.parseInt(scanner.nextLine());

        while (winningNumbers.contains(bonusNumber)) {
            System.out.println("이미 있는 번호입니다.\n다시 입력해주세요.");
            bonusNumber = Integer.parseInt(scanner.nextLine());
        }

        return bonusNumber;
    }
}
