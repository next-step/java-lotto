package lotto.view;

import lotto.util.StringParser;
import lotto.util.StringSplitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

    public static int inputManualPurchaseCount() {
        System.out.printf("%n수동으로 구매할 로또 수를 입력해 주세요.%n");
        return SCANNER.nextInt();
    }

    public static List<List<Integer>> inputManualPurchaseTickets(int PurchaseCount) {
        SCANNER.nextLine();
        System.out.printf("%n수동으로 구매할 번호를 입력해 주세요.%n");

        List<List<Integer>> tickets = new ArrayList<>();
        while (PurchaseCount-- > 0) {
            tickets.add(
                    StringParser.parseIntList(
                        StringSplitter.split(
                                SCANNER.nextLine().replace(" ", "")
                    ))
            );
        }
        return tickets;
    }

    public static List<Integer> inputLastWinningNumber() {
        System.out.println("지난 주 당첨 번호를 압력해주세요.");

        return StringParser.parseIntList(
                StringSplitter.split(
                        SCANNER.nextLine().replace(" ", "")
                ));
    }

    public static int inputBonusBallNumber() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return SCANNER.nextInt();
    }
}
