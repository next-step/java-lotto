package autolotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String WIN_NUMBER_PATTERN = ",";
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int buyAmt() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(checkNllOrBlank(scanner.nextLine()));
    }

    private static String checkNllOrBlank(String input) {
        if (input == null || input.isBlank()) {
            throw new IllegalArgumentException("입력값을 입력하지 않았습니다.");
        }
        return input;
    }

    public static List<Integer> lastWeekWinNumber() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : checkNllOrBlank(scanner.nextLine()).split(WIN_NUMBER_PATTERN)) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

    public static int bonusNumber(){
        System.out.println("\n보너스 볼을 입력해 주세요.");
        return Integer.parseInt(checkNllOrBlank(scanner.nextLine()));
    }
}
