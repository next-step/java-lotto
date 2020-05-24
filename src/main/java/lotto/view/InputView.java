package lotto.view;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final int PRICE_UNIT = 1000;
    private static final String SEPARATOR = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력하세요";
    private static final String WINNING_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력하세요.";


    private InputView(){
        throw new AssertionError();
    }

    public static int inputLottoAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);

        int price = SCANNER.nextInt();
        return price / PRICE_UNIT;
    }

    public static int[] inputWinningNumbers(){
        System.out.println(WINNING_NUMBER_MESSAGE);

        String winningNumbers = SCANNER.next();

        return Arrays.stream(winningNumbers.split(SEPARATOR))
                .map(String::trim)
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
