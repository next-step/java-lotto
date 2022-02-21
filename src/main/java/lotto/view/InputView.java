package lotto.view;

import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import lotto.domain.LottoNumber;
import lotto.domain.WinningLotto;
import lotto.util.Parser;

public class InputView {

    private static final int LOTTO_LIMIT = 6;
    private static final String WIN_BALL_INVALID = "올바른 당첨 번호 입력이 아닙니다.";
    private static final String BONUS_BALL_INVALID = "중복 된 보너스 볼 입력압나더.";
    private static final String MONEY_INPUT_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String LOTTO_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_MESSAGE = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static String getMoney() {
        System.out.println(MONEY_INPUT_MESSAGE);

        return scanner.nextLine();
    }

    public static WinningLotto getLottoWinNumber() {
        System.out.println(LOTTO_NUMBER_MESSAGE);

        List<Integer> splitInput = Parser.splitInput(scanner.nextLine());

        validateWinNumbers(splitInput);

        return WinningLotto.create(splitInput
            .stream()
            .map(LottoNumber::new)
            .collect(Collectors.toList()));
    }

    public static LottoNumber getWinBouns(WinningLotto winningLotto) {
        System.out.println(BONUS_BALL_MESSAGE);

        LottoNumber bonus = new LottoNumber(Integer.parseInt(scanner.nextLine()));

        validateBonusNumber(winningLotto, bonus);

        return bonus;
    }

    private static void validateWinNumbers(List<Integer> splitInput) {
        HashSet<Integer> duplicate = new HashSet<>(splitInput);

        if (duplicate.size() != LOTTO_LIMIT) {
            throw new IllegalArgumentException(WIN_BALL_INVALID);
        }
    }

    private static void validateBonusNumber(WinningLotto winningLotto, LottoNumber bonus) {
        if (winningLotto.getWinLotto().contains(bonus)) {
            throw new IllegalArgumentException(BONUS_BALL_INVALID);
        }
    }
}
