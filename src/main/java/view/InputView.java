package view;

import domain.Cash;
import domain.Lotto;
import domain.Lottos;

import java.util.Scanner;

public class InputView {
    private static final String CASH_INPUT_ANNOUNCEMENT = "구입금액을 입력해 주세요.";
    private final Scanner scanner;
    private Cash cash;

    public InputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public static Lottos printLottos(Lottos lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        lottos.toList().forEach(System.out::println);
        return lottos;
    }

    public Cash scanCashWithAnnouncement() {
        System.out.println(CASH_INPUT_ANNOUNCEMENT);
        this.cash = scanCash();
        return this.cash;
    }

    private Cash scanCash() {
        Cash inputCash = new Cash(scanner.nextInt());
        try {
            validateMin(inputCash);
            validateMultiple(inputCash);
            return inputCash;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return scanCash();
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

    public Cash getCash() {
        return cash;
    }
}
