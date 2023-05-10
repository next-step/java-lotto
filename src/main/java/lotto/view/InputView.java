package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static int inputPay(Scanner scanner) {
        System.out.println("구입 금액을 입력하세요.");
        return scanner.nextInt();
    }

    public static List<Integer> lastWinNumbers(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        List<Integer> numbers = new ArrayList<>();
        int count = 0;
        inputLastNumbers(numbers, count, scanner);
        return numbers;
    }

    public static int inputBonusNumber(Scanner scanner) {
        System.out.println("보너스 볼을 입력해 주세요.");
        return scanner.nextInt();
    }

    private static void inputLastNumbers(List<Integer> numbers, int count, Scanner scanner) {
        while (count < 6 && scanner.hasNextInt()) {
            int number = scanner.nextInt();
            numbers.add(number);
            count++;
        }
    }
}
