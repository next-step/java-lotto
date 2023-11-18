package step2;

import java.util.Scanner;

public class LottoInputView {
    public static int inputPurchaseMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
