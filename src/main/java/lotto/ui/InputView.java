package lotto.ui;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoPurchasePrice;

import java.util.*;
import java.util.stream.Collectors;

public class InputView {
    private static final String PURCHASE_PRICE_QUESTION = "구입금액을 입력해 주세요.";
    private static final String TICKET_COUNT_SUFFIX = "개를 구매했습니다.";
    private static final String LAST_WEEK_WINNING_NUMBERS_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_QUESTION = "보너스 볼을 입력해 주세요.";
    private static final String DELIMITER = ", ";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new UnsupportedOperationException("해당 클래스는 인스턴스를 생성할 수 없습니다.");
    }

    public static LottoPurchasePrice readTotalPurchasePrice() {
        System.out.println(PURCHASE_PRICE_QUESTION);
        LottoPurchasePrice purchasePrice = LottoPurchasePrice.valueOf(SCANNER.nextInt());
        SCANNER.nextLine();
        System.out.println(purchasePrice.getLottoCount() + TICKET_COUNT_SUFFIX);
        return purchasePrice;
    }

    public static Lotto readLastWeekWinningNumbers() {
        System.out.println(LAST_WEEK_WINNING_NUMBERS_QUESTION);
        Set<LottoNumber> winningNumbers = getWinningNumbers();
        System.out.println(BONUS_NUMBER_QUESTION);
        LottoNumber bonusNumber = getBonusNumber();
        return new Lotto(winningNumbers, bonusNumber);
    }

    private static Set<LottoNumber> getWinningNumbers() {
        return Arrays.stream(SCANNER.nextLine().split(DELIMITER))
                .map(number -> LottoNumber.valueOf(Integer.parseInt(number)))
                .collect(Collectors.toSet());
    }

    private static LottoNumber getBonusNumber() {
        return LottoNumber.valueOf(SCANNER.nextInt());
    }
}
