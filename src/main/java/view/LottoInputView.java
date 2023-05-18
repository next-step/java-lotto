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

    public static int getBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();
        return bonusNumber;
    }

    public static int getManualCount() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        int manualCount = scanner.nextInt();
        return manualCount;
    }

    public static List<int[]> getManualNumbers(int manualCount) {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
        for (int i = 0; i < manualCount; i++) {

        }
    }
}
