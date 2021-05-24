package lotto.view;

import lotto.domain.PurchaseInformation;
import lotto.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String INPUT_PRICE_MESSAGE = "구입 금액을 입력해 주세요.";
    public static final String INPUT_WINNING_NUMbERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    public static final String INPUT_MANUAL_PURCHASE_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_PURCHASE_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public PurchaseInformation inputPriceAndManualCount() {
        return new PurchaseInformation(inputPrice(), inputManualPurchaseCount());
    }

    public List<String> inputManualPurchaseNumbers(int count) {
        System.out.println();
        System.out.println(INPUT_MANUAL_PURCHASE_NUMBERS_MESSAGE);
        Scanner scanner = SCANNER.useDelimiter("\n");
        List<String> numbers = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            numbers.add(scanner.nextLine());
        }
        return numbers;
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMbERS_MESSAGE);
        return SCANNER.nextLine();
    }

    public String inputBonusNumber() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        return SCANNER.nextLine();
    }

    private int inputPrice() {
        System.out.println(INPUT_PRICE_MESSAGE);
        return StringUtils.parseInteger(SCANNER.nextLine());
    }

    private int inputManualPurchaseCount() {
        System.out.println();
        System.out.println(INPUT_MANUAL_PURCHASE_COUNT_MESSAGE);
        return StringUtils.parseInteger(SCANNER.nextLine());
    }
}
