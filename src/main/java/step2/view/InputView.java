package step2.view;

import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);

    public static int inputBuyCost() {
        ResultView.printBuyCost();
        return sc.nextInt();
    }
}
