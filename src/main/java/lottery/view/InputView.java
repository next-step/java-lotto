package lottery.view;

import java.util.Scanner;

public class InputView {

    private static Scanner scanner = new Scanner(System.in);

    public static int payAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int purchaseAmount = scanner.nextInt();

        if (purchaseAmount < 0) {
            throw new IllegalArgumentException("구매 금액은 0보다 커야 합니다.");
        }

        return purchaseAmount;
    }

}
