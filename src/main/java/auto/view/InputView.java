package auto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static auto.application.AutoService.LOTTO_MAX_NUMBER;
import static auto.application.AutoService.LOTTO_MIN_NUMBER;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String EMPTY_BONUS_BALL_MESSAGE = "보너스 볼이 비어있습니다.";
    private static final String IN_LOTTO_BONUS_BALL_MESSAGE = "로또 번호에 포함된 보너스 볼입니다.";
    private static final String NOT_RANGE_LOTTO_NUMBER_MESSAGE = "번호는 1 - 45까지 입력할 수 있습니다.";

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputWinningNumbersLastWeek() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbersLastWeek = scanner.nextLine();
        return Arrays.stream(winningNumbersLastWeek.split(", "))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    public static int inputBonusBallNumber(List<Integer> lastWeekWinningNumber) {
        System.out.println(EMPTY_BONUS_BALL_MESSAGE);
        int bonusNumber = Integer.parseInt(scanner.nextLine());
        if (lastWeekWinningNumber.contains(bonusNumber))
            throw new IllegalArgumentException(IN_LOTTO_BONUS_BALL_MESSAGE);
        if (isNotInLottoNumberRange(bonusNumber))
            throw new IllegalArgumentException(NOT_RANGE_LOTTO_NUMBER_MESSAGE);
        return bonusNumber;
    }

    private static boolean isNotInLottoNumberRange(int bonusNumber) {
        return !(bonusNumber >= LOTTO_MIN_NUMBER && bonusNumber <= LOTTO_MAX_NUMBER);
    }
}
