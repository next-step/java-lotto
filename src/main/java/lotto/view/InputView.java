package lotto.view;

import lotto.domain.LottoMagicNumber;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String LOTTO_START_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT_MESSAGE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String PURCHASE_NUMBERS_MESSAGE = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String LOTTO_WINNING_NUMBER_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String LOTTO_BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_AMOUNT_VALID_MESSAGE = "구입금액은 숫자만 입력 가능합니다.";
    private static final String LOTTO_MISMATCH_NUMBER_MESSAGE = "로또 번호는 숫자만 가능합니다.";
    private static final String LOTTO_MINIMUM_PRICE_MESSAGE = "로또를 발급하기 위한 최소 금액은 %d원 입니다.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static int purchaseAmount() {
        System.out.println(LOTTO_START_MESSAGE);
        String inputLine = SCANNER.nextLine();
        inputDigitValid(inputLine);
        if (Integer.parseInt(inputLine) < LottoMagicNumber.BASE_PRICE.get()) {
            throw new IllegalArgumentException(String.format(LOTTO_MINIMUM_PRICE_MESSAGE, LottoMagicNumber.BASE_PRICE.get()));
        }
        return Integer.parseInt(inputLine);
    }

    public static String winningNumber() {
        System.out.println(LOTTO_WINNING_NUMBER_MESSAGE);
        return SCANNER.nextLine();
    }

    public static int bonusBall() {
        System.out.println(LOTTO_BONUS_NUMBER_MESSAGE);
        return SCANNER.nextInt();
    }

    public static int manualPurchaseLottoCount() {
        System.out.println(PURCHASE_COUNT_MESSAGE);
        int inputCount = 0 ;
        try {
            inputCount = SCANNER.nextInt();
        } catch (InputMismatchException inputMismatchException) {
            throw new IllegalArgumentException(LOTTO_MISMATCH_NUMBER_MESSAGE);
        }
        return inputCount;
    }

    public static List<String> manualPurchaseLottoNumbers(int count) {
        System.out.println(PURCHASE_NUMBERS_MESSAGE);
        List<String> strings = new ArrayList<>();
        while (strings.size() != count) {
            String inputLine = SCANNER.nextLine();
            if (inputLine.isEmpty()) {
                continue;
            }
            strings.add(inputLine);
        }
        return strings;
    }

    private static void inputDigitValid(String inputLine) {
        for (int i = 0; i < inputLine.length(); i++) {
            if (!Character.isDigit(inputLine.charAt(i))) {
                throw new IllegalArgumentException(LOTTO_PURCHASE_AMOUNT_VALID_MESSAGE);
            }
        }
    }
}
