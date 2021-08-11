package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int receivePurchaseMoney() {
        String input;
        System.out.println("구입금액을 입력해 주세요.");
        do {
            input = scanner.nextLine();
        } while (!isNumber(input));
        return Integer.parseInt(input);
    }

    public static String receiveWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    private static boolean isNumber(String input) {
        if (input == null || !input.chars().allMatch(Character::isDigit)) {
            System.out.println("숫자만 입력 가능합니다.");
            return false;
        }
        return true;
    }
}
