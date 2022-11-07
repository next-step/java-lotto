package lotto.view;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private static final String INPUT_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ERROR_CHECK_AMOUNT = "금액을 입력하세요.";
    private static final String INPUT_WINNER_NUMBER_LIST = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_BALL_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner sc1 = new Scanner(System.in);
    private static final Scanner sc2 = new Scanner(System.in);
    private static final Scanner sc3 = new Scanner(System.in);

    public static BigDecimal inputAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE);
        BigDecimal amount = sc1.nextBigDecimal();
        return amount;
    }

    public static List<Integer> inputWinnerNumberList() {
        System.out.println(INPUT_WINNER_NUMBER_LIST);
        String line = sc2.nextLine();
        String[] str = line.split(", ");

        List<Integer> winnerNumberList = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            winnerNumberList.add(Integer.valueOf(str[i]));
        }

        return winnerNumberList;
    }

    public static Integer inputBonusBallNumber() {
        System.out.println(INPUT_BONUS_BALL_NUMBER);
        return sc3.nextInt();
    }
}
