package lotto.view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    public static final int LOTTO_PRICE = 1000;

    private InputView() {
    }

    public static int purchaseAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        int purchaseAmount = scanner.nextInt();

        System.out.println(quantity(purchaseAmount) + "개를 구입했습니다.");
        return purchaseAmount;
    }

    private static int quantity(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }
}
