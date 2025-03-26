package lotto.view;

import lotto.view.model.UserMoneyInput;
import lotto.view.model.WinningNumberInput;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static UserMoneyInput getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return UserMoneyInput.from(scanner.nextLine());
    }

    public static WinningNumberInput getWinnerInput() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        return WinningNumberInput.from(scanner.nextLine());
    }
}
