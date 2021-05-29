package step5.view;

import step5.lotto.Lotto;
import step5.lotto.LottoCount;
import step5.utils.StringUtils;

import java.util.Scanner;
import java.util.Set;

public class InputView {
    private static final String INPUT_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    private static final String LAST_WEEKS_WINNING_NUMBER ="지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_LOTTO_MANUAL_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_LOTTO_MANUAL_NUMBERS = "수동으로 구매할 번호를 입력해 주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
        throw new AssertionError();
    }

    public static int inputPurchasePrice() {
        System.out.println(INPUT_PURCHASE_PRICE);
        return SCANNER.nextInt();
    }

    public static String inputWinningNumbers() {
        System.out.println(LAST_WEEKS_WINNING_NUMBER);
        return SCANNER.next();
    }

    public static int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return SCANNER.nextInt();
    }

    public static int inputLottoManualCount() {
        System.out.println(INPUT_LOTTO_MANUAL_COUNT);
        return SCANNER.nextInt();
    }

    public static void inputLottoManualNumbers(Lotto lotto) {
        LottoCount lottoCount = lotto.getLottoCount();
        if (!lottoCount.isLottoManualCountZero()) {
            System.out.println(INPUT_LOTTO_MANUAL_NUMBERS);
            makeLottoManualNumbers(lotto, lottoCount.manualLottoCount());
        }
    }

    private static void makeLottoManualNumbers(Lotto lotto, int manualCount) {
        for (int i = 0; i < manualCount; i++) {
            Set<Integer> manualTickets = StringUtils.processStringNumbers(inputStringLottoManualNumbers());
            lotto.addManualLottoTicket(manualTickets);
        }
    }

    public static String inputStringLottoManualNumbers() {
        return SCANNER.next();
    }
}
