package lotto.view;

import lotto.lotto.lottonumber.LottoNumber;
import lotto.lotto.lottonumber.LottoNumbers;
import lotto.result.WinningNumbers;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String PURCHASE_AMOUNT_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String WINNING_NUMBER_REQUEST_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    public static final String BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해주세요.";

    private InputView() {
    }

    public static int getPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static WinningNumbers getWinningNumbers() {
        System.out.println(WINNING_NUMBER_REQUEST_MESSAGE);
        LottoNumbers winningNumbers = LottoNumbers.from(scanner.nextLine());

        System.out.println(BONUS_NUMBER_MESSAGE);
        LottoNumber bonusNumber = LottoNumber.from(scanner.nextLine());

        return WinningNumbers.of(winningNumbers, bonusNumber);
    }
}
