package lotto.view;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String WINNING_NUMBER_SPLIT_EXPRESSION = ",";

    private static final String PURCHASE_PRICE_COMMENT = "구입금액을 입력해 주세요.";
    private static final String LASTWEEK_LOTTO_PRIZE_NUMBER_COMMENT = "지난 주 당첨 번호를 입력해 주세요.";

    private InputView() {
    }

    public static int inputPurchasePrice() {
        System.out.println(PURCHASE_PRICE_COMMENT);

        int purchasePrice = scanner.nextInt();
        validateLottoMinPrice(purchasePrice);
        return purchasePrice;
    }

    private static void validateLottoMinPrice(int purchasePrice) {
        if (purchasePrice < 1000) {
            throw new IllegalArgumentException();
        }
    }

    public static Set<Integer> lastWeekLottoPrizeNumber() {
        System.out.println();
        System.out.println(LASTWEEK_LOTTO_PRIZE_NUMBER_COMMENT);
        String[] splitPrizeNumber = scanner.next().split(WINNING_NUMBER_SPLIT_EXPRESSION);
        return Stream.of(splitPrizeNumber)
                        .map(Integer::parseInt)
                        .collect(Collectors.toCollection(LinkedHashSet::new));

    }
}