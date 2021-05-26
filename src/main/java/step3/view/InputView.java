package step3.view;

import step3.lotto.LottoCount;

import java.util.Scanner;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_PRINT = "개를 구매했습니다.";
    private static final String LAST_WEEKS_WINNING_NUMBER ="지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static int inputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE);
        return SCANNER.nextInt();
    }

    public static void printPurchasePrice(LottoCount lottoCount) {
        System.out.println(lottoCount.getLottoCount() + PURCHASE_PRINT);
    }

    public static String inputWinningNumbers() {
        System.out.println(LAST_WEEKS_WINNING_NUMBER);
        return SCANNER.next();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return SCANNER.nextInt();
    }
}
