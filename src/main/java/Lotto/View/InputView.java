package Lotto.View;

import java.util.Scanner;

public class InputView {
    public static Integer inputMoney() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("구입금액을 입력해 주세요.\n");
        return Integer.parseInt(scanner.next());
    }
}
