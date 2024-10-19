package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner SCANNER = new Scanner(System.in);

    private InputView() {

    }

    public static int getMoney() {
        System.out.println("로또 구입 금액을 입력해 주세요.");
        return SCANNER.nextInt();
    }

}
