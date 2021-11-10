package lotto.view;

import lotto.vo.Money;

import java.util.Scanner;

public class InputView {

    private Scanner scanner = new Scanner(System.in);

    public Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        String moneyStr = scanner.nextLine();
        return Money.create(moneyStr);
    }

    public String inputWinningLotto() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return scanner.nextLine();
    }
}
