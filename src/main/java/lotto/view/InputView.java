package lotto.view;

import java.util.Scanner;

public class InputView {
    public static final Scanner scanner = new Scanner(System.in);

    public int enterPurchasePrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public String enterWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
