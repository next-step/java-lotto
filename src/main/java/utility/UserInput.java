package utility;

import domain.ValidateWinnerNumber;
import domain.WinnerNumberManager;

import java.util.Arrays;
import java.util.Scanner;

public class UserInput {

    private static final String BUY_MESSEGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSEGE = "개를 구매했습니다.";
    private static final String AFTER_MESSEGE = "지난 주 당첨 번호를 입력하세요.";
    private static final String BONUS_BALL_MESSEGE = "보너스 볼을 입력하세요.";
    private static final String DELIMTER = ",";
    public static final int WON = 1000;
    public static final Scanner SC = new Scanner(System.in);

    private UserInput() {
    }

    public static int tellHowManyBuy() {
        System.out.println(BUY_MESSEGE);
        int input = SC.nextInt();
        SC.nextLine();

        System.out.println(input + PURCHASE_MESSEGE);

        return input;
    }

    public static WinnerNumberManager getWinnerTicket() {
        String[] winnerNumber = inputWinnerNumber();
        int bonusNumber = inputBonusNumber();

        int[] number = Arrays.stream(winnerNumber)
                .mapToInt(Integer::parseInt).toArray();

        return new WinnerNumberManager(number,bonusNumber);
    }

    private static String[] inputWinnerNumber() {
        System.out.println(AFTER_MESSEGE);
        String input = SC.nextLine();
        String[] inputs = input.split(DELIMTER);

        ValidateWinnerNumber.validate(inputs);

        return inputs;
    }

    private static int inputBonusNumber() {
        System.out.println(BONUS_BALL_MESSEGE);
        int bonus = SC.nextInt();

        ValidateWinnerNumber.validateBonusNumber(bonus);

        return bonus;
    }
}
