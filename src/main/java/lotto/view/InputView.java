package lotto.view;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int readPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return InputParser.parseAmount(SCANNER.nextLine());
    }

    public static List<Integer> readWinningNumbers() {
        System.out.println();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return InputParser.parseNumbers(SCANNER.nextLine());
    }
}
