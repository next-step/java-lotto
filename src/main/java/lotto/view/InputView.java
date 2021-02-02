package lotto.view;

import lotto.domain.Validator;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int getMoneyToBuyLotto() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = scanner.nextLine();

        return Validator.checkIsIntegerAndIsNegative(input);
    }

    public static String getLottoAnswer() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String winningLottoNumber = scanner.nextLine();
        return winningLottoNumber;
    }
    public static int getBonusBall() {
        System.out.println("보너스 볼을 입력해주세요.");
        int bonusBall = scanner.nextInt();
        return bonusBall;
    }

    public static int getNumberOfManualLotto() {
        System.out.println("수동으로 구매할 로또 수를 입력해 주세요.");
        String input = scanner.nextLine();
        return Validator.checkIsIntegerAndIsNegative(input);
    }
    public static String getStringOfLotto() {
        return scanner.nextLine();
    }
}
