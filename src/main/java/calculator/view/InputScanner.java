package calculator.view;

import java.util.Scanner;

/**
 * Created by seungwoo.song on 2022-09-28
 */
public class InputScanner {

    private final Scanner scanner;

    public InputScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public String scan() {
        System.out.println("계산할 값을 입력해 주세요");
        return scanner.nextLine();
    }
}
