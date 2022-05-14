package view;

import domain.Cash;
import domain.Lotto;

import java.util.Scanner;

public class InputView {
    private static final String CASH_INPUT_ANNOUNCEMENT = "구입금액을 입력해 주세요.";
    private final Scanner scanner;
    private Cash cash;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public Cash scanCashWithAnnouncement() {
        System.out.println(CASH_INPUT_ANNOUNCEMENT);
        scanCash();
        return this.cash;
    }

    private void scanCash() {
        Cash inputCash = new Cash(scanner.nextInt());
        try {
            validateMin(inputCash);
            validateMultiple(inputCash);
            this.cash = inputCash;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            scanCash();
        }
    }

    private void validateMin(Cash inputCash) {
        if (inputCash.isLessThan(Lotto.PRICE)) {
            throw new IllegalArgumentException(String.format("구입금액은 %d 이상이어야 합니다.", Lotto.PRICE));
        }
    }

    private void validateMultiple(Cash inputCash) {
        if (!inputCash.isMultipleOf(Lotto.PRICE)) {
            throw new IllegalArgumentException(String.format("구입금액은 %d의 배수여야 합니다.", Lotto.PRICE));
        }
    }
}
