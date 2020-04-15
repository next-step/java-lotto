package lotto.view;

import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import lotto.domain.ManualCount;
import lotto.utils.Parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    public static final String AMOUNT_QUESTION = "구입금액을 입력해 주세요.";
    public static final String PRIZE_QUESTION = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_PRIZE_QUESTION = "보너스 볼을 입력해 주세요.";
    public static final String NUMBER_OF_MANUAL_PURCHASE = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String INPUT_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static Scanner scanner = new Scanner(System.in);

    public static long askNumberOfPurchase() {
        System.out.println(AMOUNT_QUESTION);
        return Long.parseLong(scanner.nextLine());
    }

    public static List<LottoNumber> askLastPrizeNumber() {
        System.out.println(PRIZE_QUESTION);
        return Parser.splitToNumbers(scanner.nextLine());
    }

    public static int askBonusPrizeNumber() {
        System.out.println(BONUS_PRIZE_QUESTION);
        return Integer.parseInt(scanner.nextLine());
    }

    public static int askManualPurchase() {
        System.out.println(NUMBER_OF_MANUAL_PURCHASE);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<LottoNumber> manualLottoNumber() {
        return Parser.splitToNumbers(scanner.nextLine());
    }

    public static List<LottoNumbers> askManualNumbers(ManualCount manualCounts) {
        List<LottoNumbers> lottoNumbers = new ArrayList<>();
        System.out.println(INPUT_MANUAL_NUMBERS);

        for (int i = 0; i < manualCounts.getManualCounts(); i++) {
            LottoNumbers lottoNumber = new LottoNumbers(InputView.manualLottoNumber());
            lottoNumbers.add(lottoNumber);
        }
        return lottoNumbers;
    }

}
