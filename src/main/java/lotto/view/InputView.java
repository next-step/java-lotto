package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {
    private static final String SEPARATOR = ",";
    private static final String INPUT_PURCHASED_AMOUNT = "구매금액을 입력해주세요.";
    private static final String INPUT_WINNING_NUMBER_LAST_WEEK = "지난 주 당첨 번호를 입력해주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);
    public static final String INPUT_BONUS_BALL = "보너스볼 번호를 입력하세요.";

    public static int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASED_AMOUNT);
        return SCANNER.nextInt();
    }

    public static List<Integer> winningsNumberLastWeek() {
        String winningsNumber = inputWinningsNumberLastWeek();
        return convertedStringToIntegerList(winningsNumber);
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_BALL);
        return SCANNER.nextInt();
    }

    private static String inputWinningsNumberLastWeek() {
        System.out.println(INPUT_WINNING_NUMBER_LAST_WEEK);
        return SCANNER.next();
    }

    public static List<Integer> convertedStringToIntegerList(String winningsNumber) {
        return Stream.of(winningsNumber.split(SEPARATOR))
                .map(value -> Integer.parseInt(value.trim()))
                .collect(Collectors.toList());
    }

}
