package step3.view.view;

import java.util.Scanner;

/*
 * InputView
 * ver. 1.0
 * 2020.05.31
 */
public class InputView {

    private static final String QUESTION_PAY_MONEY = "How much do you pay for Lotto Games ? : ";
    private static final String QUESTION_LAST_WEEK_WINNING_NUMBER = "Input Winning Number of last week. : ";
    private static final String QUESTION_LAST_WEEK_BONUS_BALL_NUMBER = "Input Bonus Number of last week. : ";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String inputPayMoney() {
        System.out.println(QUESTION_PAY_MONEY);
        String result = SCANNER.next();
        return result;
    }

    public static String inputWiningNumber() {
        System.out.println(QUESTION_LAST_WEEK_WINNING_NUMBER);
        String result = SCANNER.next();
        return result;
    }

    public static String inputBonusNumber() {
        System.out.println(QUESTION_LAST_WEEK_BONUS_BALL_NUMBER);
        String result = SCANNER.next();
        return result;
    }

}
