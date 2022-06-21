package view;

import domain.Cash;
import domain.Lotto;
import domain.Lottos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static final String CASH_INPUT_ANNOUNCEMENT = "구입금액을 입력해 주세요.";
    private static final String INVALID_CASH_ANNOUNCEMENT = "구입금액은 정수만 가능합니다.";
    private final Scanner scanner;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static Lottos printLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.toList().forEach(System.out::println);
        System.out.println();
        return lottos;
    }

    public Cash scanCashWithAnnouncement() {
        System.out.println(CASH_INPUT_ANNOUNCEMENT);
        return scanCash();
    }

    private Cash scanCash() {
        try {
            Cash inputCash = new Cash(scanIntForCash());
            validateMin(inputCash);
            validateMultiple(inputCash);
            return inputCash;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return scanCash();
        }
    }

    private int scanIntForCash() {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println(INVALID_CASH_ANNOUNCEMENT);
            scanner.nextLine();
            return scanIntForCash();
        }
    }

    private void validateMin(Cash inputCash) {
        if (inputCash.isLessThan(Lotto.PRICE)) {
            throw new IllegalArgumentException(String.format("구입금액은 %s 이상이어야 합니다.", Lotto.PRICE));
        }
    }

    private void validateMultiple(Cash inputCash) {
        if (!inputCash.isMultipleOf(Lotto.PRICE)) {
            throw new IllegalArgumentException(String.format("구입금액은 %s의 배수여야 합니다.", Lotto.PRICE));
        }
    }
}
