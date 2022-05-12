package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.LottoTotalPrice;
import lotto.domain.WinningLotto;
import lotto.util.SplitStringUtils;
import lotto.util.StringNumberUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static lotto.domain.LottoTotalPrice.UNIT_LOTTO_PRICE;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final int ZERO = 0;
    private static final String COMMA_DELIMITER = ",";
    private static final String PURCHASE_AMOUNT_GUIDE = "구입금액을 입력해 주세요.";
    private static final String MANUAL_LOTTO_COUNT_GUIDE = "\n수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String MANUAL_LOTTO_NUMBERS_GUIDE = "\n수동으로 구매할 번호를 입력해 주세요.";
    private static final String WINNING_NUMBER_GUIDE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_GUIDE = "보너스 볼을 입력해 주세요.";
    private static final String RE_SCAN_GUIDE = " 다시 입력 해주세요.";

    private InputView() {
    }

    public static LottoTotalPrice scanPurchaseAmount() {
        System.out.println(PURCHASE_AMOUNT_GUIDE);
        LottoTotalPrice lottoTotalPrice;
        try {
            lottoTotalPrice = new LottoTotalPrice(StringNumberUtils.parse(scanner.nextLine()));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + RE_SCAN_GUIDE);
            lottoTotalPrice = scanPurchaseAmount();
        }
        return lottoTotalPrice;
    }

    public static List<Lotto> scanManualLottos(int manualLottoCount) {
        System.out.println(MANUAL_LOTTO_NUMBERS_GUIDE);
        List<Lotto> manualLottos = new ArrayList<>();
        try {
            for (int i = 0; i < manualLottoCount; i++) {
                manualLottos.add(Lotto.create(SplitStringUtils.split(scanner.nextLine(), COMMA_DELIMITER)));
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + RE_SCAN_GUIDE);
            manualLottos = scanManualLottos(manualLottoCount);
        }
        return manualLottos;
    }

    public static int scanManualLottosCount(LottoTotalPrice lottoTotalPrice) {
        System.out.println(MANUAL_LOTTO_COUNT_GUIDE);
        int manualLottoCount = ZERO;
        try {
            manualLottoCount = StringNumberUtils.parse(scanner.nextLine());
            validateLottoCount(manualLottoCount, lottoTotalPrice);
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + RE_SCAN_GUIDE);
            manualLottoCount = scanManualLottosCount(lottoTotalPrice);
        }
        return manualLottoCount;
    }

    private static void validateLottoCount(int manualLottoCount, LottoTotalPrice lottoTotalPrice) {
        if (manualLottoCount < ZERO) {
            throw new IllegalArgumentException(String.format("입력받은 로또 갯수(%d)는 음수일 수 없습니다.", manualLottoCount));
        }
        if (lottoTotalPrice.lessThan(manualLottoCount * UNIT_LOTTO_PRICE)) {
            throw new IllegalArgumentException(String.format("총 구매 금액을 초과하는 로또 갯수(%d)를 입력 받았습니다.", manualLottoCount));
        }
    }

    public static Lotto scanWinningLotto() {
        System.out.println(WINNING_NUMBER_GUIDE);
        Lotto winningLotto;
        try {
            winningLotto = Lotto.create(SplitStringUtils.split(scanner.nextLine(), COMMA_DELIMITER));
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + RE_SCAN_GUIDE);
            winningLotto = scanWinningLotto();
        }
        return winningLotto;
    }

    public static WinningLotto getWinningLotto(Lotto lotto) {
        WinningLotto winningLotto;
        try {
            winningLotto = new WinningLotto(lotto, scanBonusNumber());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + RE_SCAN_GUIDE);
            winningLotto = getWinningLotto(lotto);
        }
        return winningLotto;
    }

    public static LottoNumber scanBonusNumber() {
        System.out.println(BONUS_BALL_GUIDE);
        LottoNumber bonusNumber;
        try {
            bonusNumber = LottoNumber.create(scanner.nextLine());
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage() + RE_SCAN_GUIDE);
            bonusNumber = scanBonusNumber();
        }
        return bonusNumber;
    }
}
