package step2;

import java.util.Scanner;

public class PurchaseScanner implements TheMethodOfPurchase {
    private int amount;

    @Override
    public void input() {
        Scanner scan = new Scanner(System.in);
        amount = scan.nextInt();
    }

    @Override
    public int getAmount() {
        return amount;
    }
}
