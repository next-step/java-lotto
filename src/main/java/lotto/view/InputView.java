package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private final static Scanner scanner = new Scanner(System.in);

    private InputView() {
    }

    public static int inputPurchaseAmount() {
        int purchaseAmount = 0;

        try {
            System.out.println("구입금액을 입력해 주세요.");
            purchaseAmount = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("잘못된 입력입니다. 다시 입력해주세요");
        }
        return purchaseAmount;
    }
}
