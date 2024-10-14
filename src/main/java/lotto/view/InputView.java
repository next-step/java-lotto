package lotto.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public int inputPurchaseAmountGuide() {
        System.out.println("구매 금액을 입력해주세요.");
        return inputPurchaseAmount();
    }

    private int inputPurchaseAmount() {
        return scanner.nextInt();
    }

    public String inputWinnerNumber() {
        clearBuffer();
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }

    private void clearBuffer() {
        scanner.nextLine();
    }

}
