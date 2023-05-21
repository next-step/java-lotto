package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class InputView {

    private static final String REQUEST_PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    private static final String REQUEST_WINNING_NUMBERS_INPUT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_INPUT = "보너스 볼을 입력해 주세요.";
    private static final String SPLITTER = ", ";
    private static final Scanner SCANNER = new Scanner(System.in);

    public int requestPurchaseAmount() {
        System.out.println(REQUEST_PURCHASE_AMOUNT_INPUT);
        return getIntNumber();
    }

    public Lotto requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS_INPUT);
        Set<LottoNumber> requestedWinningNumbers = Arrays.stream(SCANNER.nextLine().split(SPLITTER))
                .map(Integer::parseInt)
                .map(LottoNumber::new)
                .collect(Collectors.toSet());
        return new Lotto(requestedWinningNumbers);
    }

    public LottoNumber requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_INPUT);
        return new LottoNumber(getIntNumber());
    }

    private int getIntNumber() {
        return Integer.parseInt(SCANNER.nextLine());
    }
}
