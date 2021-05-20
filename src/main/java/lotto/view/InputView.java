package lotto.view;

import lotto.domain.LottoNumber;
import lotto.util.TextParser;

import java.util.List;
import java.util.Scanner;

/**
 * 사용자의 입력을 처리한다.
 */
public class InputView {
    private static final String MONEY_AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    private static final String PRIZE_NUMBER_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private final Scanner scanner;

    public InputView() {
        scanner = new Scanner(System.in);
    }

    public long askMoneyInput() {
        System.out.println(MONEY_AMOUNT_QUESTION);
        return Long.parseLong(scanner.nextLine());
    }

    public List<LottoNumber> askLastPrizeNumber() {
        System.out.println(PRIZE_NUMBER_QUESTION);
        return TextParser.parseToLottoNumbers(scanner.nextLine());
    }
}
