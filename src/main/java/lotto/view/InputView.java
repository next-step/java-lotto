package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String NUMBER_ERROR = "숫자만 입력가능합니다.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private static String inputValue() {
        return SCANNER.nextLine();
    }

    public static int inputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        String inputValue = SCANNER.nextLine();
        validateNumber(inputValue);
        return Integer.parseInt(inputValue);
    }

    private static void validateNumber(final String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_ERROR);
        }
    }
}
