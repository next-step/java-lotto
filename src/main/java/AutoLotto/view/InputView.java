package AutoLotto.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    private static final String VALID_NUMBER = "[0-9]\\d*";

    private static final String PURCHASE_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_DENIED = "1,000원 단위로 구매 가능합니다.\n구입금액을 다시 입력해주세요.";
    private static final String WIN_NUMBERS_QUESTION = "당첨 번호 6개를 입력해주세요. \n (ex : 1,2,3,4,5,6)";
    private static final String WIN_NUMBERS_DENIED = "쉼표를 기준으로 6개의 숫자를 입력하셔야 합니다.\n구입금액을 다시 입력해주세요.";

    public int inputPurchase() {
        return getChances();
    }

    private int getChances() {
        outputQuestion(PURCHASE_AMOUNT_QUESTION);
        String input = scanner.nextLine();

        while (!isValidNumberInput(input) || !isValidPaymentUnit(input)) {
            outputQuestion(PURCHASE_DENIED);
            input = scanner.nextLine();
        }

        return convertStringToNumber(input);
    }

    private void outputQuestion(String question) {
        System.out.println(question);
    }

    private boolean isValidNumberInput(String input) {
        return input.matches(VALID_NUMBER);
    }

    private boolean isValidPaymentUnit(String input) {
        return input.endsWith("000") && input.length() >= 4;
    }

    private int convertStringToNumber(String input) {
        String strippedInput = input.substring(0, input.length() - 3);

        return Integer.parseInt(strippedInput);
    }
}
