package lotto.view;

import lotto.domain.Money;

import java.util.Scanner;

public class InputView {
    public static Scanner scanner = new Scanner(System.in);

    public static Money inputPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        return Money.initMoney(scanner.nextInt());
    }
}
