package lotto.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import lotto.domain.Ball;
import lotto.domain.Count;
import lotto.domain.Lotto;
import lotto.domain.Money;

public class LottoReader {

    private static final String DELIMITER = ",";
    private static final String INPUT_WINNING_LOTTO_NUMBERS_MESSAGE = "지난 주 당첨 번호를 입력해주세요.";
    private static final String INPUT_BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final String SPACE = " ";
    private static final String EMPTY_STRING = "";
    private static final String INPUT_MONEY_GUIDE_MESSAGE = "구입 금액을 입력해주세요.";
    private static final String INPUT_COUNT_MESSAGE = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String INPUT_MANUAL_LOTTO_MESSAGE = "수동으로 구매할 번호를 입력해 주세요.";

    public Money readMoney() {
        System.out.println(INPUT_MONEY_GUIDE_MESSAGE);

        Scanner scanner = new Scanner(System.in);

        return new Money(scanner.nextLine());
    }

    public Lotto readWinningLotto() {
        System.out.println(INPUT_WINNING_LOTTO_NUMBERS_MESSAGE);

        Scanner scanner = new Scanner(System.in);

        return readLottoNumber(scanner.nextLine());
    }

    public Ball readBonusBall() {
        System.out.println(INPUT_BONUS_BALL_MESSAGE);

        Scanner scanner = new Scanner(System.in);

        return new Ball(scanner.nextLine());
    }

    public Count readCount() {
        System.out.println(INPUT_COUNT_MESSAGE);

        Scanner scanner = new Scanner(System.in);

        return new Count(scanner.nextLine().replace(SPACE, EMPTY_STRING));
    }

    public List<Lotto> readManualLottos(final Count count) {
        System.out.println(INPUT_MANUAL_LOTTO_MESSAGE);

        final Scanner scanner = new Scanner(System.in);
        final List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < count.getValue(); i++) {
            lottos.add(readLottoNumber(scanner.nextLine()));
        }

        return lottos;
    }

    private Lotto readLottoNumber(final String numbers) {
        List<Ball> winningLottoBalls = new ArrayList<>();

        String winningLottoNumbers = numbers.replace(SPACE, EMPTY_STRING);

        for (String winningLottoNumber : winningLottoNumbers.split(DELIMITER)) {
            winningLottoBalls.add(new Ball(winningLottoNumber));
        }

        return new Lotto(winningLottoBalls);
    }
}
