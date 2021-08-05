package lottos.view;

import java.util.Scanner;

public class LottoConsoleInputView {

    public int enterPurchaseAmount(Scanner scanner, int amountPerPiece) {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(scanner.nextLine());
        int purchaseCount = purchaseAmount / amountPerPiece;
        System.out.printf("%d개를 구매했습니다.%n", purchaseCount);
        return purchaseAmount;
    }

    public String enterLastWeeksNumbers(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
