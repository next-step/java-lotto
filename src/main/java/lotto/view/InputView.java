package lotto.view;

import java.util.Scanner;

public class InputView {
    private final static Scanner scanner = new Scanner(System.in);

    public static int Input() {
        System.out.println("구입금액을 입력해 주세요.");
        return scanner.nextInt();
    }
}
