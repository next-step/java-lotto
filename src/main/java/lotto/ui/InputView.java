package lotto.ui;

import lotto.domain.Price;

import java.util.Scanner;

public class InputView {
    public static Price getPrice() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new Price(scanner.nextInt());
    }
}
