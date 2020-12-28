package lotto.ui;

import java.util.List;
import java.util.Scanner;

public class inputView {
    int purchaseAmount;
    String winningNum;

    public void inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        purchaseAmount = sc.nextInt();
    }

    public void inputWinningNum() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        Scanner sc = new Scanner(System.in);
        winningNum = sc.nextLine();
    }

    public int getPurchaseAmount() {
        return purchaseAmount;
    }

    public String getWinningNum() {
        return winningNum;
    }
}
