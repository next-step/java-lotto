package caculator.view;

import java.util.Scanner;

public class InputView {
    public static String inputString() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("사칙연산식을 입력하여 주세요.");
        return scanner.nextLine();
    }
}
