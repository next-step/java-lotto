package lotto.view;

import lotto.domain.LottoCount;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    public static final String ENTER_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String ENTER_WINNING_NUMBERS = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String ENTER_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    public static final String ENTER_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    public static final String ENTER_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    protected static int enterLottoAmount() {
        System.out.println(ENTER_PURCHASE_AMOUNT);
        return scanner.nextInt();
    }

    protected static String enterWinningNumbers() {
        System.out.println(ENTER_WINNING_NUMBERS);
        return scanner.nextLine();
    }

    protected static int enterBonusNumber() {
        System.out.println(ENTER_BONUS_NUMBER);
        return scanner.nextInt();
    }

    protected static int enterManualLottoCount() {
        System.out.println(ENTER_MANUAL_LOTTO_COUNT);
        return scanner.nextInt();
    }

    protected static List<String> enterManualLottoNumber(LottoCount lottoCount) {
        List<String> result = new ArrayList<>();
        System.out.println(ENTER_MANUAL_LOTTO_NUMBER);
        scanner.nextLine();
        for (int i = 0; i < lottoCount.getValue(); i++) {
            result.add(scanner.nextLine());
        }
        return result;
    }
}
