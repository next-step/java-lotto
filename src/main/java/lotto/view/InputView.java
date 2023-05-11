package lotto.view;

import lotto.common.code.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String BUY_AMOUNT_INPUT_TEXT = "구입금액을 입력해 주세요.";
    private static final String LAST_WEEK_WINNING_NUMBER_INPUT_TEXT = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String BONUS_BALL_NUMBER_INPUT_TEXT = "보너스 볼을 입력해 주세요.";
    private static final String BONUS_BALL_ERROR_TEXT = "로또 번호에 포함된 보너스 볼은 입력할 수 없습니다.";
    private static final String OVER_RANGE_LOTTO_NUMBER_TEXT = "번호는 1 - 45까지 입력할 수 있습니다.";
    private static final String LAST_WEEK_WINNING_NUMBER_REX_PATTERN = ", ";


    public static int inputBuyAmount() {
        System.out.println(BUY_AMOUNT_INPUT_TEXT);
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<Integer> inputLastWeekWinningNumber() {
        System.out.println(LAST_WEEK_WINNING_NUMBER_INPUT_TEXT);
        String lastWeekWinningNumber = scanner.nextLine();
        System.out.println(lastWeekWinningNumber);
        return Arrays.stream(lastWeekWinningNumber.split(LAST_WEEK_WINNING_NUMBER_REX_PATTERN))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static int inputBonusBallNumber(List<Integer> lastWeekWinningNumber) {
        System.out.println(BONUS_BALL_NUMBER_INPUT_TEXT);
        int bonusNumber = Integer.parseInt(scanner.nextLine());
        if (hasLottoNumbers(lastWeekWinningNumber, bonusNumber)) throw new IllegalArgumentException(BONUS_BALL_ERROR_TEXT);
        if (isNotWithinLotteryNumberRange(bonusNumber)) throw new IllegalArgumentException(OVER_RANGE_LOTTO_NUMBER_TEXT);
        return bonusNumber;
    }

    static boolean hasLottoNumbers(List<Integer> lastWeekWinningNumber, int bonusNumber) {
        return lastWeekWinningNumber.contains(bonusNumber);
    }

    static boolean isNotWithinLotteryNumberRange(int bonusNumber) {
        return !(bonusNumber >= LottoNumber.MINIMUM_LOTTO_NUMBER.getNumber()
                && bonusNumber <= LottoNumber.MAXIMUM_LOTTO_NUMBER.getNumber());
    }

}
