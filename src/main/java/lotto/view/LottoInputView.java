package lotto.view;

import lotto.domain.LottoCount;
import lotto.domain.LottoNumberRepository;
import lotto.domain.WinningLotto;

import java.util.Scanner;

public class LottoInputView {
    private static final String INPUT_PRICE_MESSAGE = "구입금액을 입력해주세요.";
    private static final String INPUT_BEFORE_WIN_LOTTO_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해주세요.";
    private static final String INPUT_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);

    public static LottoCount getLottoCount() {
        try {
            System.out.println(INPUT_PRICE_MESSAGE);
            String price = SCANNER.nextLine();
            System.out.println(INPUT_MANUAL_LOTTO_COUNT_MESSAGE);
            String manualCount = SCANNER.nextLine();
            return new LottoCount(price, manualCount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottoCount();
        }
    }

    public static WinningLotto getWinningLotto() {
        try {
            System.out.println(INPUT_BEFORE_WIN_LOTTO_MESSAGE);
            String winningLottos = SCANNER.nextLine();

            System.out.println(INPUT_BONUS_MESSAGE);
            String bonus = SCANNER.nextLine();
            return new WinningLotto(winningLottos, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningLotto();
        }
    }

    public static LottoNumberRepository getLottoNumberRepository(LottoCount lottoCount) {
        if (!lottoCount.isManualCount()) {
            return new LottoNumberRepository();
        }

        return getManualLottoNumberRepository(lottoCount);
    }

    private static LottoNumberRepository getManualLottoNumberRepository(LottoCount lottoCount) {
        try {
            System.out.println(INPUT_MANUAL_LOTTO_MESSAGE);
            LottoNumberRepository lottoNumberRepository = new LottoNumberRepository();
            int manualCount = lottoCount.manualCount();
            while (manualCount > 0) {
                lottoNumberRepository.add(SCANNER.nextLine());
                manualCount--;
            }

            return lottoNumberRepository;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getManualLottoNumberRepository(lottoCount);
        }
    }
}
