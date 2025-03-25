package lotto.view;

import lotto.UserMoneyInput;
import lotto.WinnerNumberInput;

import java.util.Scanner;

public class UserInputProcessor {
    private static final Scanner scanner = new Scanner(System.in);

    public static UserMoneyInput getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return UserMoneyInput.from(scanner.nextLine());
    }

    public static WinnerNumberInput getWinnerInput() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return WinnerNumberInput.from(scanner.nextLine());
    }
}
