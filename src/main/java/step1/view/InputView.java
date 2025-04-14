package step1.view;

import java.util.Scanner;

public class InputView {
    Scanner scanner = new Scanner(System.in);

    public String[] init() {
        System.out.println("계산식을 입력하세요.");
        String input = scanner.nextLine();
        return input.split(" ");
    }

}
