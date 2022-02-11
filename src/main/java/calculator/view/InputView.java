package calculator.view;

import java.util.Scanner;

public class InputView {

    public String getUserInput() {
        System.out.println("문자열을 입력하세요");
        Scanner scanner = new Scanner(System.in);

        return scanner.nextLine();
    }

}
