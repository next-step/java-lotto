package step2.view;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.util.stream.Collectors.toList;

public class InputView {
    private static final int LOTTO_PRICE = 1000;

    private static final Scanner scanner = new Scanner(System.in);

    public static Integer inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");

        int money = Integer.parseInt(scanner.nextLine());
        validateInput(money);

        return money;
    }

    private static void validateInput(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException(money + "는 최소금액보다 적습니다.");
        }
    }

    public static Integer inputManualAmount(int price) {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualAmount = Integer.parseInt(scanner.nextLine());

        validateManualAmount(manualAmount, price);
        return manualAmount;
    }

    private static void validateManualAmount(int manualAmount, int price) {
        if (manualAmount < 0) {
            throw new IllegalArgumentException(manualAmount + " : 양의 갯수를 입력해주새요.");
        }
        if (manualAmount * LOTTO_PRICE > price) {
            throw new IllegalArgumentException("수동으로 구매할 돈이 부족합니다.");
        }
    }

    public static List<List<Integer>> inputManualNumbers(int amount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        List<List<Integer>> manualNumbers = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            manualNumbers.add(convert(splitNumbers(scanner.nextLine())));
        }
        return manualNumbers;
    }

    private static List<Integer> convert(String[] numbers) {
        return Arrays.stream(numbers)
                .map(Integer::parseInt)
                .collect(toList());
    }


    public static List<Integer> inputWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return convert(splitNumbers(scanner.nextLine()));
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
