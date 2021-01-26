package calculator;

import java.util.Scanner;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static String getInputText() {

        System.out.println("덧셈을 할 식을 입력해주세요");
        return scanner.nextLine();
    }

}
