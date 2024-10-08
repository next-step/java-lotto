package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final int ZERO = 0;
    private static final String INPUT_PURCHASE_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INCORRECT_VALUE_ERROR_MESSAGE = "숫자만 입력 가능합니다.";
    private static final String INCORRECT_RANGE_ERROR_MESSAGE = ZERO + "보다 낮은 수는 입력할 수 없습니다.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public InputView() {
    }

    public static String inputValue() {
        return SCANNER.nextLine();
    }

    public static int getPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE_MESSAGE);
        String inputValue = inputValue();
        validatePurchasePrice(inputValue);
        return Integer.parseInt(inputValue);
    }

    private static void validatePurchasePrice(final String inputValue) {
        validateNumberValue(inputValue);
        validateRange(inputValue);
    }

    private static void validateNumberValue(final String inputValue) {
        try {
            Integer.parseInt(inputValue);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INCORRECT_VALUE_ERROR_MESSAGE);
        }
    }

    private static void validateRange(final String inputValue) {
        int value = Integer.parseInt(inputValue);
        if (value < ZERO) {
            throw new IllegalArgumentException(INCORRECT_RANGE_ERROR_MESSAGE);
        }
    }

}
