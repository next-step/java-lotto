package lotto;

import java.util.Scanner;

public class UserInput {

    public static Money inputMoney() {
        System.out.println("구입금액을 입력해 주세요.");
        Scanner scanner = new Scanner(System.in);
        return new Money(scanner.nextInt());
    }
}
