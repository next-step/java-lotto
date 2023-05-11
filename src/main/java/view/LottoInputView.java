package view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LottoInputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String DELIMITER = ", ";

    public static int getMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        int money = scanner.nextInt();
        return money;
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        scanner.nextLine();
        List<Integer> lastWeekWinningNumbers = new ArrayList<>();
        String[] numbers = scanner.nextLine().split(DELIMITER);
        for (String number : numbers) {
            lastWeekWinningNumbers.add(Integer.parseInt(number));
        }
        return lastWeekWinningNumbers;
    }
}
