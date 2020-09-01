package utility;

import domain.Lotto;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class UserInput {
    private static final String BUY_MESSEGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_MESSEGE = "개를 구매했습니다.";
    private static final String AFTER_MESSEGE = "지난 주 당첨 번호를 입력하세요.";
    private static final String DELIMTER = ",";
    private static final String BONUS_MESSEGE = "보너스 볼을 입력해 주세요.";

    public static final int WON = 1000;
    public static final Scanner SC = new Scanner(System.in);

    private UserInput() {
    }

    public static int tellHowManyBuy() {
        System.out.println(BUY_MESSEGE);
        int input = SC.nextInt();
        SC.nextLine();

        System.out.println(input/WON+ PURCHASE_MESSEGE);

        return input;
    }

    public static Lotto getWinnerTicket() {
        String[] winnerNumber = inputWinnerNumber();

        Set<Integer> lotto = Arrays.stream(winnerNumber)
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());

        return new Lotto(lotto);
    }

    private static String[] inputWinnerNumber() {
        System.out.println(AFTER_MESSEGE);
        String input = SC.nextLine();
        String[] inputs = input.split(DELIMTER);

        return inputs;
    }

    public static int inputBonusNumber(){
        System.out.println(BONUS_MESSEGE);

        return SC.nextInt();
    }
}
