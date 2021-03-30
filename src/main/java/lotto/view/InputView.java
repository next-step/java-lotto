package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final String LOTTO_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String LOTTO_PURCHASE_MANUAL_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    private static final Scanner scanner = new Scanner(System.in);
    private static final LottoGenerator lottoGenerator = LottoGenerator.getInstance();

    private InputView() {
    }

    public static int enterLottoPurchaseAmount() {
        System.out.println(LOTTO_PURCHASE_AMOUNT_MESSAGE);
        return scanner.nextInt();
    }

    public static List<Lotto> enterLottoPurchaseManualCount() {
        System.out.println(LOTTO_PURCHASE_MANUAL_COUNT_MESSAGE);
        int manualLottoCount = scanner.nextInt();
        scanner.nextLine();
        System.out.println(MANUAL_NUMBERS_MESSAGE);
        List<Lotto> lottoList = new ArrayList<>();
        for (int i = 0; i < manualLottoCount; i++) {
            lottoList.add(
                    Lotto.of(lottoGenerator.generateAppointedLotto(scanner.nextLine()))
            );
        }

        return lottoList;
    }

    public static String enterWinningNumbers() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return scanner.nextLine();
    }

    public static int enterBonusBall() {
        System.out.println(BONUS_BALL_MESSAGE);
        return scanner.nextInt();
    }
}
