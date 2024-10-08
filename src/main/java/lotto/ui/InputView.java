package lotto.ui;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_PRICE_QUESTION = "구입금액을 입력해 주세요.";
    private static final String TICKET_COUNT_SUFFIX = "개를 구매했습니다.";
    private static final String LAST_WEEK_WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final int LOTTO_TICKET_PRICE = 1000;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final int LOTTO_BOUND = 45;
    private static final String DELIMITER = ", ";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new UnsupportedOperationException("해당 클래스는 인스턴스를 생성할 수 없습니다.");
    }

    public static int readTotalPurchasePrice() {
        System.out.println(PURCHASE_PRICE_QUESTION);
        int totalPurchasePrice = SCANNER.nextInt();
        SCANNER.nextLine();
        validatePurchasePrice(totalPurchasePrice);
        System.out.println((totalPurchasePrice / LOTTO_TICKET_PRICE) + TICKET_COUNT_SUFFIX);
        return totalPurchasePrice;
    }

    public static List<Integer> readLastWeekWinningNumbers() {
        System.out.println(LAST_WEEK_WINNING_NUMBERS_QUESTION);
        List<Integer> winningNumbers = getWinningNumbers();
        validateLottoNumbersSize(winningNumbers);
        winningNumbers.forEach(lottoNumber ->
                validateLottoNumber(lottoNumber));
        return winningNumbers;
    }

    private static List<Integer> getWinningNumbers() {
        return Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .mapToInt(Integer::parseInt)
                .boxed()
                .collect(Collectors.toList());
    }

    private static void validateLottoNumbersSize(final List<Integer> winningNumbers) {
        if (winningNumbers.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException("로또번호의 개수는 6개여야 합니다.");
        }
    }

    private static void validatePurchasePrice(final int totalPurchasePrice) {
        if (totalPurchasePrice % LOTTO_TICKET_PRICE != 0) {
            throw new IllegalArgumentException("올바른 구매금액이 아닙니다. 로또 개수에 맞게 금액을 넣어주세요.(1장당 1000원)");
        }
    }

    private static void validateLottoNumber(final int lottoNumber) {
        if (lottoNumber < 1 && lottoNumber > LOTTO_BOUND) {
            throw new IllegalArgumentException("올바른 로또 번호가 아닙니다.(1이상 45이하 아님)");
        }
    }

}
