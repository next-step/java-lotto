package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        String inputValue = scanner.nextLine();
        return Integer.parseInt(inputValue);
    }

    public static String inputWinningNumbersLastWeek() {
        System.out.println(System.lineSeparator() + "지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int inputBonusNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        String inputValue = scanner.nextLine();
        return Integer.parseInt(inputValue);
    }

}
