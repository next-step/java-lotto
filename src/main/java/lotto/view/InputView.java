package lotto.view;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public int inputPrice() {
        System.out.println("구입급액을 입력해주세요.");
        return scanner.nextInt();
    }
}
