package lotto.view;

import lotto.domain.Money;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {}

    public static Money inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(SCANNER.nextInt());
    }

}
