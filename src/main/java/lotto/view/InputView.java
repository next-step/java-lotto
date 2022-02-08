package lotto.view;

import java.util.List;
import java.util.Scanner;
import lotto.domain.WinningLotto;
import lotto.util.InputValidator;
import lotto.util.MoneyValidator;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputMoney() {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            return MoneyValidator.validate(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputMoney();
        }
    }

    public static List<Integer> inputLastWinningNumbers() {
        try {
            System.out.println("지난 주 당첨 번호를 입력해 주세요.");
            return InputValidator.validate(SCANNER.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputLastWinningNumbers();
        }
    }

    public static void inputBonusNumber(WinningLotto winningLotto) {
        try {
            System.out.println("보너스 볼을 입력해주세요.");
            int bonusNumber = InputValidator.parseToInt(SCANNER.nextLine());
            winningLotto.setBonusNumber(bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNumber(winningLotto);
        }
    }
}
