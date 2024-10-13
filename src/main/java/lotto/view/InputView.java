package lotto.view;

import java.util.Scanner;

public class InputView {

    public int inputPurchaseAmountGuide(Scanner scanner) {
        System.out.println("구매 금액을 입력해주세요.");
        return inputPurchaseAmount(scanner);
    }

    private int inputPurchaseAmount(Scanner scanner) {
        return scanner.nextInt();
    }

    public String inputWinnerNumber(Scanner scanner) {
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        return scanner.nextLine();
    }
}
