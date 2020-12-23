package lotto.ui;

import java.util.Scanner;

public class inputView {
    int purchaseAmount;

    public void inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        purchaseAmount = sc.nextInt();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }
}
