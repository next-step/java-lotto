package lotto.view;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    private static final String INPUT_MESSAGE_LOTTO_MONEY = "구입금액을 입력해 주세요.";
    private static final String INPUT_MESSAGE_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String INPUT_MESSAGE_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    public static final String REGEX = ", ";

    public static int getLottoMoney() {
        System.out.println(INPUT_MESSAGE_LOTTO_MONEY);
        return scanner.nextInt();
    }

    public static List<Integer> getWinningNumbers() {
        System.out.println(INPUT_MESSAGE_WINNING_NUMBER);
        scanner.nextLine();

        String winningLottoNumber = scanner.nextLine();

        return getCommonLottoNumbers(winningLottoNumber);
    }

    public static int getBonusBall() {
        System.out.println(INPUT_MESSAGE_BONUS_BALL);
        return scanner.nextInt();
    }

    public static List<Integer> getCommonLottoNumbers(String winningLottoNumber) {
        return Arrays.stream(winningLottoNumber.split(REGEX))
                .map(InputView::toInt)
                .collect(Collectors.toList());
    }

    private static int toInt(String inputNumbers) {
        if (!StringUtils.isNumeric(inputNumbers)) {
            throw new IllegalArgumentException("숫자가 아닙니다.");
        }
        return Integer.parseInt(inputNumbers);
    }
}
