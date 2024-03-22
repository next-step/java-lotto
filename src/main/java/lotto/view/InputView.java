package lotto.view;

import java.util.Scanner;

public class InputView {

    static Scanner scanner = new Scanner(System.in);

    public static String inputAmount() {
        System.out.println("구입 금액을 입력해주세요.");
        return scanner.nextLine();
    }
}
