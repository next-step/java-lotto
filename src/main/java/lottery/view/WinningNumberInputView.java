package lottery.view;

import java.util.Scanner;
import lottery.domain.WeeklyWinningNumbers;

public class WinningNumberInputView {

    private static final String INPUT_MSG = "지난 주 당첨 번호를 입력해 주세요.";

    private static final String BONUS_INPUT_MSG = "보너스 볼을 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static WeeklyWinningNumbers winningNumbers() {
        printSource(INPUT_MSG);
        String winningNumbers = SCANNER.next();

        printSource(BONUS_INPUT_MSG);
        return new WeeklyWinningNumbers(winningNumbers, SCANNER.nextInt());
    }

    private static void printSource(String source) {
        System.out.println(source);
    }
}
