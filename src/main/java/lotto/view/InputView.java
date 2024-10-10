package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public static final String IS_NOT_NUMBER = "숫자를 입력해주세요.";
    private static final Scanner SCANNER = new Scanner(System.in);
    public static int inputInt(Runnable messagePrinter) {
        try {
            messagePrinter.run();
            int count = SCANNER.nextInt();
            SCANNER.nextLine();
            return count;
        } catch (InputMismatchException ex) {
            SCANNER.nextLine();
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        } catch (Exception ex) {
            SCANNER.nextLine();
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }
    }
    public static String inputStr(Runnable messagePrinter) {
        messagePrinter.run();
        return SCANNER.nextLine().replaceAll("\\s+", "");
    }
}
