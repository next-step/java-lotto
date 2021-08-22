package lotto.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import static lotto.util.StringUtil.split;

public class InputView {
    private static final String FIRST_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBER = "지난 주 당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_BALL_NUMBER = "보너스 볼을 입력해 주세요.";
    private static final String ASK_MANUAL_LOTTO_COUNT = "수동으로 구매할 로또 수를 입력해 주세요.";
    private static final String ASK_MANUAL_LOTTO_NUMBER = "수동으로 구매할 번호를 입력해 주세요.";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int askPurchasePrice() {
        System.out.println(FIRST_MESSAGE);
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("구입금액을 잘못 입력했습니다.\n");
            return askPurchasePrice();
        }
    }

    public static List<Integer> getWinningNumber() {
        System.out.println(ASK_WINNING_NUMBER);
        try {
            return Arrays.stream(split(SCANNER.nextLine()))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            return getWinningNumber();
        }
    }

    public static String askBonusNumber() {
        System.out.println(ASK_BONUS_BALL_NUMBER);
        return SCANNER.nextLine();
    }

    public static int askManualLottoCount() {
        System.out.println(ASK_MANUAL_LOTTO_COUNT);
        try {
            return Integer.parseInt(SCANNER.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력 하세요");
            return askManualLottoCount();
        }
    }

    public static List<Integer> getAskManualLottoNumber() {
        System.out.println(ASK_MANUAL_LOTTO_NUMBER);
        try {
            return Arrays.stream(split(SCANNER.nextLine()))
                    .map(Integer::valueOf)
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            return getAskManualLottoNumber();
        }
    }

}
