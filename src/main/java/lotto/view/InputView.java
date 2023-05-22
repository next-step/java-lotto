package lotto.view;

import java.util.Scanner;

public class InputView {

    private final int purchasePrice;


    InputView() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("구입금액을 입력해 주세요.");
        purchasePrice = Integer.parseInt(scanner.nextLine());
    }

    public boolean purchasePriceIsEqualTo(int purchasePrice) {
        return this.purchasePrice == purchasePrice;
    }
}
