package view;

import java.util.List;
import java.util.Scanner;

import util.Utils;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String WINNING_NUMBER_SEPARATOR = ", ";

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public List<Integer> inputWinningLottoNumbers() {
        System.out.println("\n지난 주 당첨 번호를 입력해 주세요.");
        removeNewLine();
        return Utils.convertToNumbers(SCANNER.nextLine().split(WINNING_NUMBER_SEPARATOR));
    }

    public int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    private void removeNewLine() {
        SCANNER.nextLine();
    }
}
