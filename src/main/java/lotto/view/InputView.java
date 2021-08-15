package lotto.view;

import java.util.Scanner;

public class InputView {
    private final Scanner scanner;

    public InputView(final Scanner scanner) {
        this.scanner = scanner;
    }

    public int receivePurchaseMoney() {
        return receiveNumber("구입금액을 입력해 주세요.");
    }

    public String receiveWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public int receiveBonusNumber() {
        return receiveNumber("보너스 볼을 입력해 주세요.");
    }

    private int receiveNumber(String message) {
        String input;
        System.out.println(message);
        do {
            input = scanner.nextLine();
        } while (!isNumber(input));
        return Integer.parseInt(input);
    }

    private boolean isNumber(String input) {
        if (input == null || !input.chars().allMatch(Character::isDigit)) {
            System.out.println("숫자만 입력 가능합니다.");
            return false;
        }
        return true;
    }
}
