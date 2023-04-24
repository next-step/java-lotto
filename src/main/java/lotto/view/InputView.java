package lotto.view;

import lotto.util.StringParser;
import lotto.util.StringSplitter;

import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }

    public static List<Integer> inputLastWinningNumber() {
        scanner.nextLine();
        System.out.println("지난 주 당첨 번호를 압력해주세요.");
        return StringParser.parseIntList(
                StringSplitter.split(
                        scanner.nextLine().replace(" ", "")
                ));
    }
}
