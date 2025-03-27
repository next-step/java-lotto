package lotto.view;

import lotto.view.model.UserMoneyInput;
import lotto.domain.model.WinningLotto;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static UserMoneyInput getMoneyInput() {
        System.out.println("구입금액을 입력해 주세요.");
        return UserMoneyInput.from(scanner.nextLine());
    }

    public static WinningLotto getWinnerInput() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        String winningNumbers = scanner.nextLine();

        System.out.println("보너스 볼을 입력해 주세요.");
        int bonusNumber = scanner.nextInt();

        return WinningLotto.of(winningNumbers, bonusNumber);
    }


}
