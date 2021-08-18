package StringCalculator;

import java.util.Scanner;

public class InputView {

    static String getUserInput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("계산식을 입력하세요.");
        return sc.nextLine();
    }
}
