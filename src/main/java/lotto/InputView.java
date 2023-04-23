package lotto;

import java.util.Scanner;

public class InputView {
    private static final Scanner sc = new Scanner(System.in);
    public static int getPurchaseAmount() {
        System.out.println("구입 금액을 입력해 주세요.");
        return sc.nextInt();
    }
}
