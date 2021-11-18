package step2.view;

import java.util.Scanner;

public class LottoInput {

    private static final Scanner scanner = new Scanner(System.in);

    public int inputMoney() {
        System.out.println("구입 금액을 입력해주세요");
        return scanner.nextInt();
    }
}
