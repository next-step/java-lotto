package lotto;

import java.util.Scanner;

public class InputView {

    private final Scanner sc = new Scanner(System.in);

    public void inputPurchasePrice(LottoViewController viewController) {
        System.out.println("구입금액을 입력해 주세요.");
        viewController.setPurchasePrice(sc.nextInt());
    }
}
