package lotto.view;

import lotto.Money;
import lotto.WinningNumber;

import java.util.Scanner;

public class InputView {
    public static Money getPrice() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.");
        int price = scanner.nextInt();
        return new Money(price);
    }

    public static WinningNumber getWinningNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("지난 주 당첨 번호를 입력해 주세요.");
        String numbers = scanner.nextLine();
        return new WinningNumber(numbers);
    }
}
