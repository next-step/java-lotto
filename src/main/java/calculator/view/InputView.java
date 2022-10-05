package calculator.view;

import java.util.Scanner;

/**
 * Created by seungwoo.song on 2022-10-05
 */
public class InputView {
    private InputView() {
    }

    private static final Scanner SCANNER = new Scanner(System.in);

    public static String read() {
        System.out.println("계산할 값을 입력해 주세요");
        return SCANNER.nextLine();
    }
}
