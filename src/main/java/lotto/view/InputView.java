package lotto.view;

import lotto.domain.Lotto;
import lotto.util.Parser;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int purchase() {
        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        scanner.nextLine();
        return price;
    }

    public static Lotto winningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return Parser.parseWinningNumbers(scanner.nextLine());
    }
}
