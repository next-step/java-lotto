package step2.view;

import java.util.Scanner;

public class InputView {

    private static final String INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final Scanner scanner = new Scanner(System.in);

    public static String price() {
        System.out.println(INPUT_MESSAGE);
        return scanner.nextLine();
    }

}
