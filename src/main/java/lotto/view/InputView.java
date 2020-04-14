package lotto.view;

import lotto.domain.LottoNumber;
import lotto.utils.Parser;

import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    public static final String PRIZE_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_PRIZE_QUESTION = "보너스 볼을 입력해 주세요.";
    public static final String NUMBER_OF_MANUAL_PURCHASE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public long askNumberOfPurchase() {
        System.out.println(AMOUNT_QUESTION);
        return Long.parseLong(scanner.nextLine());
    }

    public List<LottoNumber> askLastPrizeNumber() {
        System.out.println(PRIZE_QUESTION);
        return Parser.splitToNumbers(scanner.nextLine());
    }

    public int askBonusPrizeNumber() {
        System.out.println(BONUS_PRIZE_QUESTION);
        return Integer.parseInt(scanner.nextLine());
    }

    public int askManualPurchase() {
        System.out.println(NUMBER_OF_MANUAL_PURCHASE);
        return Integer.parseInt(scanner.nextLine());
    }

    public List<LottoNumber> manualLottoNumber() {
        return Parser.splitToNumbers(scanner.nextLine());
    }

    public void askManualLottoNumber() {
        System.out.println("수동으로 구매할 번호를 입력해 주세요.");
    }

}
