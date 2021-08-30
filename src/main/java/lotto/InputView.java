package lotto;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static int getPurchaseAmount() {
        printPurchaseAmount();
        return inputPurchaseAmount();
    }

    private static void printPurchaseAmount() {
        System.out.println("구입금액을 입력해주세요.");
    }

    private static int inputPurchaseAmount() {
        return scanner.nextInt();
    }
}
