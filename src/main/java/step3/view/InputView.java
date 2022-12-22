package step3.view;

import java.util.Arrays;
import java.util.Scanner;


public class InputView {
    private static Scanner scanner = new Scanner(System.in);

    public static int inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputMoney = scanner.nextLine();
        if (!InputException.isInputMoneyPossible(inputMoney)) {
            scanner = new Scanner(System.in);
            return inputMoney();
        }
        int money = Integer.parseInt(inputMoney);
        int number = money / 1000;
        System.out.print(number);
        System.out.println("개를 구매했습니다.");
        return number;
    }

    public static Integer[] inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");

        String input = scanner.nextLine();
        String[] winningLotto = input.split(", ");

        if (!InputException.isInputLottoPossible(winningLotto) || !InputException.isInputLottoRangePossible(winningLotto)) {
            scanner = new Scanner(System.in);
            return inputWinningLotto();
        }

        return Arrays.stream(winningLotto).map(Integer::parseInt).toArray(Integer[]::new);
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");

        String bonusNumber = scanner.nextLine();

        if (!InputException.isInputBonusPossible(bonusNumber)) {
            scanner = new Scanner(System.in);
            return inputBonusNumber();
        }
        return Integer.parseInt(bonusNumber);
    }
}
