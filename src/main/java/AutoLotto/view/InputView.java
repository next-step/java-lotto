package autoLotto.view;

import java.util.Arrays;
import java.util.Scanner;

import static autoLotto.model.LottoConstants.*;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    private static final String VALID_NUMBER = "[0-9]\\d*";
    private static final String VALID_WIN_NUMBER = "^[0-9]{1,2}(,[0-9]{1,2})*$";
    private static final Long DIVISION_UNIT = 1000L;

    private static final String PURCHASE_AMOUNT_QUESTION = "구입금액을 숫자로만 입력해 주세요.\n(ex : 1000)";
    private static final String PURCHASE_DENIED = "1,000원 단위로 구매 가능합니다.\n구입금액을 다시 입력해주세요.";
    private static final String WIN_NUMBERS_QUESTION = "당첨 번호 6개를 입력해주세요.\n(ex : 1,2,3,4,5,6)";
    private static final String WIN_NUMBERS_DENIED = "공백없이 쉼표를 기준으로 1 ~ 45 사이의 숫자 6개의 숫자를 입력하셔야 합니다.\n당첨 번호를 다시 입력해주세요.\n(ex: 1,2,3,4,5,6)";
    private static final String BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요.";
    private static final String BONUS_NUMBER_DENIED = "1 ~ 45 사이의 숫자 1개만 입력이 가능합니다.\n금액을 다시 입력해주세요>(ex: 1)";

    public String inputPurchase() {
        return startPurchase();
    }

    private String startPurchase() {
        outputQuestion(PURCHASE_AMOUNT_QUESTION);
        String input = scanner.nextLine();

        while (!isValidNumberInput(input) || !isValidPaymentUnit(input)) {
            outputQuestion(PURCHASE_DENIED);
            input = scanner.nextLine();
        }

        return input;
    }

    private void outputQuestion(String question) {
        System.out.println(question);
    }

    private boolean isValidNumberInput(String input) {
        return input.matches(VALID_NUMBER);
    }

    private boolean isValidPaymentUnit(String input) {
        Long inputLong = Long.parseLong(input);
        return inputLong / DIVISION_UNIT >= 1;
    }

    public String inputWinNumbers() {
        return confirmWinNumbers();
    }

    private String confirmWinNumbers() {
        outputQuestion(WIN_NUMBERS_QUESTION);
        String input = scanner.nextLine();
        input = removeAllEmptySpaces(input);

        while(!isValidInputWinNumbers(input) || !isValidWinNumbers(input)) {
            outputQuestion(WIN_NUMBERS_DENIED);
            input = scanner.nextLine();
            input = removeAllEmptySpaces(input);
        }

        return input;
    }

    private String removeAllEmptySpaces(String input) {
        return input.replaceAll("\\s", "");
    }

    private boolean isValidInputWinNumbers(String input) {
        return input.matches(VALID_WIN_NUMBER);
    }

    private boolean isValidWinNumbers(String input) {
        String[] values = splitNumbersByComma(input);

        if (values.length != VALID_LOTTO_LENGTH) {
            return false;
        }

        int[] numbers = stringsToInts(values);
        return isValidWinNumber(numbers);
    }

    private String[] splitNumbersByComma(String input) {
        return input.split(",");
    }

    private int[] stringsToInts(String[] values) {
        int[] numbers = new int[values.length];

        for (int i = 0; i < VALID_LOTTO_LENGTH; i++) {
            numbers[i] = Integer.parseInt(values[i]);
        }

        return numbers;
    }

    private boolean isValidWinNumber(int[] numbers) {
        Arrays.sort(numbers);
        return numbers[0] >= LOTTO_START_NUMBER && numbers[VALID_LOTTO_LENGTH - 1] <= LOTTO_END_NUMBER;
    }

    public int inputBonusNumber() {
        outputQuestion(BONUS_NUMBER_QUESTION);
        int input = scanner.nextInt();

        while (!isValidBonusNumber(input)) {
            outputQuestion(BONUS_NUMBER_DENIED);
            input = scanner.nextInt();
        }

        return input;
    }

    private boolean isValidBonusNumber(int number) {
        return number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER;
    }

}
