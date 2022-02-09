package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import lotto.model.Parser;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PRICE_INPUT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String WINNING__NUMBER_INPUT_GUIDE_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_INPUT_GUIDE_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String NEED_OVER_1000 = "1000원 이상의 금액을 입력해주세요.";
    private static final String NEED_INTEGER = "정수를 입력해주세요.";
    private static final int PRICE_OF_A_LOTTO = 1000;

    public static int inputPrice() {
        System.out.println(PRICE_INPUT_GUIDE_MESSAGE);
        return SCANNER.nextInt();
    }

    private static void validatePrice(int price) {
        if (price < PRICE_OF_A_LOTTO) {
            throw new RuntimeException(NEED_OVER_1000);
        }
    }

    private static void validateIsNumber(String priceString) {
        try {
            Integer.parseInt(priceString);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(NEED_INTEGER);
        }
    }

    public static List<String> inputWinningNumbers() {
        System.out.println(WINNING__NUMBER_INPUT_GUIDE_MESSAGE);
        String inputWinningNumbers = SCANNER.nextLine();
        return Arrays.asList(inputWinningNumbers.split(" |,"));
    }

    public static int inputBonusBall() {
        System.out.println(BONUS_BALL_INPUT_GUIDE_MESSAGE);
        return SCANNER.nextInt();
    }
}
