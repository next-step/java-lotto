package lotto.view;

import lotto.model.Money;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(scanner.nextInt());
    }
}
