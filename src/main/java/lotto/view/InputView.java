package lotto.view;

import java.util.List;
import java.util.Scanner;

public class InputView {
    private static final String SPLIT_REGEX = "[ ,]+";
    private static final Scanner scanner = new Scanner(System.in);

    private InputView() {}

    private static void println(String str) {
        System.out.println(str);
    }

    private static List<Integer> askLotto() {
        String lotto = scanner.nextLine();
        InputValidator.validateNpe(lotto);
        return Splitter.splitIntegers(lotto, SPLIT_REGEX);
    }

    public static List<Integer> askWinningLotto() {
        println("지난 주 당첨 번호를 입력해 주세요.");
        return askLotto();
    }

    public static int askBonusBall() {
        println("보너스 볼을 입력해 주세요.");
        String bonus = scanner.nextLine();
        InputValidator.validateNumber(bonus);
        return Integer.parseInt(bonus);
    }

    public static int askPurchaseMoney() {
        println("구입금액을 입력해 주세요.");
        String money = scanner.nextLine();
        InputValidator.validateNumber(money);
        return Integer.parseInt(money);
    }

}
