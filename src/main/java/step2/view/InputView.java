package step2.view;

import java.util.Scanner;

public class InputView {
    private int purchasingAmount = 0;
    private final Scanner scanner = new Scanner(System.in);

    public int receivePurchasingAmount() {
        this.purchasingAmount = scanner.nextInt();
        printBuyLotto();
        return purchasingAmount / 1000;
    }

    private void printBuyLotto() {
        System.out.println(purchasingAmount / 1000 + "개를 구매했습니다.");
        printReturnChange();
    }

    private void printReturnChange() {
        if (purchasingAmount % 1000 > 0) {
            System.out.println("거스름돈 " + purchasingAmount % 1000 + "원을 받았습니다.");
        }
    }
}
