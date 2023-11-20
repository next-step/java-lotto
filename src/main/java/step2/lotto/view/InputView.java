package step2.lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String INPUT_PURCHASE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBER_MESSAGE = "지난 주 당첨 번호를 입력해 주세요.";

    public int inputMoney() {
        System.out.println(INPUT_PURCHASE_MESSAGE);
        return Integer.parseInt(scanner.nextLine());
    }

    public String inputWinNumbers() {
        System.out.println(INPUT_WIN_NUMBER_MESSAGE);
        return scanner.nextLine();
    }

}
