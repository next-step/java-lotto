package step2;

import java.util.Scanner;

public class InputView {
    // 구입금액입력
    static Scanner sc = new Scanner(System.in);

    public static int inputBuyCost() {
        ResultView.printBuyCost();
        return sc.nextInt();
    }
}
