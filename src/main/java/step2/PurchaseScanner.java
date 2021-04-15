package step2;

import java.util.Scanner;

public class PurchaseScanner implements TheMethodOfPurchase {
    private int amount;

    @Override
    public void input() {
        Scanner scan = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        amount = scan.nextInt();
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
