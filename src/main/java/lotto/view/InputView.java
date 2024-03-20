package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Ball;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_MONEY_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_BALLS_MESSAGE = "\n지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTO_BONUS_BALL_MESSAGE = "보너스 볼을 입력해주세요.";
    private static final String LOTTO_NUMBERS_DELIMITER = ",";

    public int inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public WinningLotto inputWinningLotto() {
        Set<Ball> lottoBalls = inputWinningLottoBalls();
        Ball bonusBall = inputBonusBall();

        return new WinningLotto(lottoBalls, bonusBall);
    }

    private Set<Ball> inputWinningLottoBalls() {
        System.out.println(INPUT_WINNING_LOTTO_BALLS_MESSAGE);
        String strLottoNumbers = scanner.nextLine();
        return Arrays.stream(strLottoNumbers.split(LOTTO_NUMBERS_DELIMITER))
            .map(String::trim)
            .map(Integer::valueOf)
            .map(Ball::new)
            .collect(Collectors.toUnmodifiableSet());
    }

    private Ball inputBonusBall() {
        System.out.println(INPUT_WINNING_LOTTO_BONUS_BALL_MESSAGE);
        int bonusBallNumber = scanner.nextInt();
        return new Ball(bonusBallNumber);
    }

    public Lottos inputManualLottos() {
        int manualLottoAmount = inputManualLottoAmount();
        System.out.println("\n수동으로 구매할 번호를 입력해 주세요.");
        List<Lotto> lottos = IntStream.range(0, manualLottoAmount)
            .mapToObj(i -> inputLotto())
            .collect(Collectors.toUnmodifiableList());
        return new Lottos(lottos);
    }

    private int inputManualLottoAmount() {
        System.out.println("\n수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    private Lotto inputLotto() {
        String strLottoNumbers = scanner.nextLine();
        Set<Ball> balls = Arrays.stream(strLottoNumbers.split(LOTTO_NUMBERS_DELIMITER))
            .map(String::trim)
            .map(Integer::valueOf)
            .map(Ball::new)
            .collect(Collectors.toUnmodifiableSet());
        return new Lotto(balls);
    }
}
