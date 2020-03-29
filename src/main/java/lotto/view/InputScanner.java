package lotto.view;

import lotto.model.Money;

import java.util.List;
import java.util.Scanner;

public class InputScanner {
    private static final String REQUEST_FOR_MONEY = "구입금액을 입력해 주세요.";
    private static final String REQUEST_FOR_WINNING_LOTTO = "지난 주 당첨번호를 입력해 주세요.";
    private static final String REQUEST_FOR_BONUS_BALL = "보너스 볼을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static Money getPurchasePrice() {
        System.out.println(REQUEST_FOR_MONEY);
        String money = scanner.nextLine();
        return StringConverter.convertStringToMoney(validateNullOrEmpty(money));
    }

    public static int getBonusBall(){
        System.out.println(REQUEST_FOR_BONUS_BALL);
        String bonusBall = scanner.nextLine();
        return StringConverter.convertStringToNumber(bonusBall);
    }

    public static List<Integer> getWinningLotto() {
        System.out.println(REQUEST_FOR_WINNING_LOTTO);
        return StringConverter.convertStringToNumbers(scanner.nextLine());
    }

    private static String validateNullOrEmpty(String input) {
        if (input == null || input.isEmpty()) {
            throw new IllegalArgumentException("null 또는 공백은 입력할 수 없습니다.");
        }
        return input;
    }
}