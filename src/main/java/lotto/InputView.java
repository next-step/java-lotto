package lotto;

import java.util.Scanner;


public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static PurchasePrice getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new PurchasePrice(scanner.nextLine());
    }

    public static LottoTicket getWinningTicket() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();
        System.out.println("보너스 볼을 입력해 주세요.");
        String bonusNumber = scanner.nextLine();
        return new LottoTicket(numbers, bonusNumber);
    }
}
