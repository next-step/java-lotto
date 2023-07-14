package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Ball;
import lotto.domain.Lotto;
import lotto.domain.ManualLottoBuyCount;
import lotto.domain.Money;
import lotto.domain.WinningLotto;

public class LottoReader {

    private static final String DELIMITER = ",";
    private static final String INPUT_MANUAL_LOTTO_BUY_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";

    public ManualLottoBuyCount readManualLottoBuyCount(Money money) {
        System.out.println(INPUT_MANUAL_LOTTO_BUY_COUNT_MESSAGE);
        Scanner scanner = new Scanner(System.in);
        return new ManualLottoBuyCount(Integer.parseInt(scanner.nextLine()), money);
    }

    public WinningLotto readWinningLotto() {
        return new WinningLotto(
                readLotto(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE),
                readBonusBall()
        );
    }

    private Lotto readLotto(final String inputManualLottoNumbersMessage) {
        System.out.println(inputManualLottoNumbersMessage);
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
