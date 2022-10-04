package lotto.view;

import java.util.Scanner;

import lotto.domain.Money;
import lotto.domain.Number;

public class ConsoleInputView {
    private final Scanner input;

    public ConsoleInputView() {
        input = new Scanner(System.in);
    }

    public Money paidMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        return new Money(input.nextLong());
    }

    public Number lastLuckyNumber() {
        System.out.println("지난 주 당첨 번호를 입력해주세요.");
        return Number.of(input.next());
    } 
}
