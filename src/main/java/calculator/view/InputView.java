package calculator.view;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner = new Scanner(System.in);

    public String input() {
        System.out.println("계산할 문자열을 입력해주세요 ex) 2 + 3 * 4 / 2");
        return scanner.nextLine();
    }
}
