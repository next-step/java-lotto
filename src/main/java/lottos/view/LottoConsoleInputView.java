package lottos.view;

import java.util.Scanner;

public class LottoConsoleInputView {

    private final Scanner scanner;

    public LottoConsoleInputView(Scanner scanner) {
        this.scanner = scanner;
    }

    public int enterPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return Integer.parseInt(scanner.nextLine());
    }

    public String enterLastWeeksNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
