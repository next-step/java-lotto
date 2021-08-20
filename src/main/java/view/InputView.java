package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {

    private static Scanner SCANNER = new Scanner(System.in);

    public static String enterLottoNumber() {
        return enterString();
    }

    public static String enterString() {
        return SCANNER.next();
    }

    public static int enterNumber() throws InputMismatchException {
        int number;
        while (true) {
            try {
                number = SCANNER.nextInt();
                return number;
            } catch (InputMismatchException e) {
                System.out.println("숫자가 아닌 값을 입력하였습니다");
                SCANNER = new Scanner(System.in);
            }
        }
    }
}
