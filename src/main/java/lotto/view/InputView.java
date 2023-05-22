package lotto.view;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private static final String NEWLINE = System.lineSeparator();

    public static int getPriceFromUser() {
        System.out.println("구입 금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int getManualPurchaseAmountFromUser() {
        System.out.println(NEWLINE + "수동으로 구매할 로또 수를 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public static List<String> getManualPurchaseLottoNumberFromUser(int amount) {
        System.out.println(NEWLINE + "수동으로 구매할 번호를 입력해 주세요.");
        return IntStream.range(0, amount).boxed()
                .map(x -> scanner.nextLine())
                .collect(Collectors.toList());
    }

    public static String getWinNumberFromUser() {
        System.out.println(NEWLINE + "지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    public static int getBonusNumberFromUser() {
        System.out.println("보너스 볼을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }
}
