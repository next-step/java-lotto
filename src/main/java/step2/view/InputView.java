package step2.view;

import java.util.Scanner;

public class InputView {
    private Scanner scanner = new Scanner(System.in);

    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        int purchaseAmount = scanner.nextInt();
        scanner.nextLine();
        return purchaseAmount;
    }

    public String getWinningNumbers() {
        System.out.println("지난주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine().replace(" ", "");
    }


}
