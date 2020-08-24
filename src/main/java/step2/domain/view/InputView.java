package step2.domain.view;

import step2.domain.User;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String inputMoney() {
        System.out.println("구입금액을 입력해주세요.");
        return scanner.next();
    }
}
