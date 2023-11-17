package lotto.view;

import lotto.domain.Amount;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {
    private final static Scanner SCANNER = new Scanner(System.in);
    private final static String PURCHASE_AMOUNT_INPUT_DESCRIPTION = "구입금액을 입력해 주세요.";
    private final static String MANUAL_LOTTO_COUNT_INPUT_DESCRIPTION = "수동으로 구매할 로또 수를 입력해 주세요.";
    private final static String MANUAL_LOTTO_INPUT_DESCRIPTION = "수동으로 구매할 번호를 입력해 주세요..";
    private final static String WINNING_NUMBER_INPUT_DESCRIPTION = "지난 주 당첨 번호를 입력해 주세요.";
    public static final String BONUS_INPUT_DESCRIPTION = "보너스 볼을 입력해 주세요.";

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_INPUT_DESCRIPTION);
        return SCANNER.nextInt();
    }

    public static int inputManualLottoCount() {
        System.out.println(MANUAL_LOTTO_COUNT_INPUT_DESCRIPTION);
        return SCANNER.nextInt();
    }

    public static List<Lotto> inputManualLotto(final int manualLottoCount) {
        System.out.println(MANUAL_LOTTO_INPUT_DESCRIPTION);

        List<Lotto> manualLottos = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            String tokens = SCANNER.next();
            manualLottos.add(new Lotto(tokens));
        }

        return manualLottos;
    }

    public static String inputWinningNumber() {
        System.out.println(WINNING_NUMBER_INPUT_DESCRIPTION);
        return SCANNER.next();
    }

    public static int inputBonusNumber() {
        System.out.println(BONUS_INPUT_DESCRIPTION);
        return SCANNER.nextInt();
    }
}
