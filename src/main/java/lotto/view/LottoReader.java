package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Ball;
import lotto.domain.BoughtLottos;
import lotto.domain.Lotto;
import lotto.domain.LottoBuyCount;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class LottoReader {

    private static final String DELIMITER = ",";
    private static final String INPUT_MANUAL_LOTTO_BUY_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    public LottoBuyCount readManualLottoBuyCount(Money money) {
        System.out.println(INPUT_MANUAL_LOTTO_BUY_COUNT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return new LottoBuyCount(scanner.nextLine(), money);
    }

    public BoughtLottos readManualLottos(final LottoBuyCount lottoBuyCount) {
        if (lottoBuyCount.isZero()) {
            return BoughtLottos.EMPTY;
        }
        System.out.println(INPUT_MANUAL_LOTTO_NUMBERS_MESSAGE);
        final List<Lotto> manualBoughtLotto = new ArrayList<>();
        for (LottoBuyCount count = lottoBuyCount; !count.isZero(); count = count.decrease()) {
            System.out.println(count.getValue() + "개 더 입력해주세요.");
            manualBoughtLotto.add(readLotto());
        }
        return new BoughtLottos(manualBoughtLotto);
    }

    public WinningLotto readWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);
        Lotto winningLotto = readLotto();
        Ball bonusBall = readBonusBall();
        return new WinningLotto(winningLotto, bonusBall);
    }

    private Lotto readLotto() {
        Scanner scanner = new Scanner(System.in);
        List<Ball> lottoBalls = new ArrayList<>();
        final String lottoNumbers = scanner.nextLine();
        for (String lottoNumber : lottoNumbers.split(DELIMITER)) {
            lottoBalls.add(new Ball(lottoNumber.trim()));
        }
        return new Lotto(lottoBalls);
    }

    private Ball readBonusBall() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return new Ball(scanner.nextLine());
    }
}
