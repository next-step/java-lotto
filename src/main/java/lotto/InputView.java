package lotto;

import java.util.Scanner;

public class InputView {
    Scanner scan;

    InputView() {
        scan = new Scanner(System.in);
    }

    public int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return scan.nextInt();
    }
}
