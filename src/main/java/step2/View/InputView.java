package step2.View;

import step2.dto.Lotto;
import step2.dto.Money;

import java.util.Scanner;

public class InputView {
    public Money getMoneyInput() {
        System.out.println("구입금액을 입력해주세요");
        int money = new Scanner(System.in).nextInt();
        return new Money(money);
    }

    public Lotto getWinningNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        String values = new Scanner(System.in).next();
        return new Lotto(values);
    }
}
