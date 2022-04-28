package lotto.ui;

import lotto.exception.InvalidPriceException;

import java.util.Scanner;

public class InputView {
    private static final String PURCHASE_PRICE_MESSAGE = "구입금액을 입력해주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String PREVIOUS_WEEK_LOTTO_MESSAGE = "지난 주 당첨번호를 입력해주세요.";
    private static final String BONUS_NUMBER_MESSAGE = "보너스 볼을 입력해주세요.";

    private InputView() {
    }

    public static int inputPrice() {
        System.out.println(PURCHASE_PRICE_MESSAGE);
        int price = SCANNER.nextInt();
        try {
            validatePrice(price);
        } catch (InvalidPriceException e) {
            System.out.println(e.getMessage());
            return inputPrice();
        }
        SCANNER.nextLine(); // Delete newLine
        return price;
    }

    public static void validatePrice(int price) {
        if (price < 0) {
            throw new InvalidPriceException(price);
        }
    }

    public static String inputLottoOfPreviousWeek() {
        System.out.println(PREVIOUS_WEEK_LOTTO_MESSAGE);
        return SCANNER.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_NUMBER_MESSAGE);
        return SCANNER.nextInt();
    }
}
