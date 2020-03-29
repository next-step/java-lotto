package lotto.view;

import lotto.model.Money;
import lotto.model.winninglotto.BonusBall;
import lotto.model.winninglotto.WinningLottoNumbers;

import java.util.List;
import java.util.Scanner;

public class InputScanner {
    private static final String REQUEST_FOR_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUEST_FOR_WINNING_LOTTO = "지난 주 당첨번호를 입력해 주세요.";
    private static final String REQUEST_FOR_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final String MSG_NULL_EMPTY_NOT_ALLOWED = "null 또는 공백은 입력할 수 없습니다.";
    private static final String MSG_BONUS_NUMBER = "당첨 번호에 포함된 번호는 보너스 번호가 될 수 없습니다.";
    private static final Scanner scanner = new Scanner(System.in);

    private static List<Integer> winningLotto;

    public static Money getPurchasePrice() {
        System.out.println(REQUEST_FOR_MONEY);
        String money = scanner.nextLine();
        return StringConverter.convertStringToMoney(validateNullOrEmpty(money));
    }

    public static WinningLottoNumbers getWinningLotto() {
        System.out.println(REQUEST_FOR_WINNING_LOTTO);
        winningLotto = StringConverter.convertStringToNumbers(scanner.nextLine());
        return new WinningLottoNumbers(winningLotto);
    }

    public static BonusBall getBonusBall() {
        System.out.println(REQUEST_FOR_BONUS_BALL);
        String input = scanner.nextLine();
        int bonusBall = validateBonusBall(StringConverter.convertStringToNumber(input));
        return BonusBall.of(bonusBall);
    }

    private static String validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException(MSG_NULL_EMPTY_NOT_ALLOWED);
        }
        return input;
    }

    private static int validateBonusBall(int bonusBall) {
        if (winningLotto.contains(bonusBall)) {
            System.out.println(MSG_BONUS_NUMBER);
            getBonusBall();
        }
        return bonusBall;
    }
}