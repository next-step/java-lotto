package lotto.ui;

import lotto.domain.Lotto;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_PRICE_QUESTION = "구입금액을 입력해 주세요.";
    private static final String TICKET_COUNT_SUFFIX = "개를 구매했습니다.";
    private static final String LAST_WEEK_WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final String DELIMITER = ", ";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new UnsupportedOperationException("해당 클래스는 인스턴스를 생성할 수 없습니다.");
    }

    public static int readTotalPurchasePrice() {
        System.out.println(PURCHASE_PRICE_QUESTION);
        int purchasePrice = SCANNER.nextInt();
        SCANNER.nextLine();
        validatePurchasePrice(purchasePrice);
        System.out.println((purchasePrice / LOTTO_TICKET_PRICE) + TICKET_COUNT_SUFFIX);
        return purchasePrice;
    }

    public static Lotto readLastWeekWinningNumbers() {
        System.out.println(LAST_WEEK_WINNING_NUMBERS_QUESTION);
        return getWinningNumbers();
    }

    private static Lotto getWinningNumbers() {
        Set<Integer> numbers = Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toSet());
        return new Lotto(numbers);
    }

    private static void validatePurchasePrice(final int purchasePrice) {
        if (purchasePrice % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
        }
    }
}
