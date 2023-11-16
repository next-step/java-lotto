package autolotto.ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner;

    static {
        scanner = new Scanner(System.in);
    }

    public static int buyAmt() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> lastWeekWinNumber(){
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String[] winningNumberStrings = scanner.nextLine().split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for (String number : winningNumberStrings) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

}
