package lottery.view;

import java.util.Scanner;

public class BonusNumberConsoleInput {

    private static final String BONUS_BALL_QUESTION = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    public static String askBonusBall() {
        System.out.println(BONUS_BALL_QUESTION);
        return scanner.nextLine();
    }
}
