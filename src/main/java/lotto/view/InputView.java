package lotto.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    public static final String IS_NOT_NUMBER = "숫자를 입력해주세요.";
    private static final String BLINK_INPUT_ERROR = "입력된 값이 없습니다.";
    private static final String DELIMETER = ",";

    private static final Scanner SCANNER = new Scanner(System.in);

    public static int inputInt(Runnable messagePrinter) {
        try {
            messagePrinter.run();
            int num = SCANNER.nextInt();
            SCANNER.nextLine();
            return num;
        } catch (InputMismatchException ex) {
            SCANNER.nextLine();
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        } catch (Exception ex) {
            SCANNER.nextLine();
            throw new IllegalArgumentException(IS_NOT_NUMBER);
        }
    }

    public static String[] inputLotto(Runnable messagePrinter) {
        messagePrinter.run();
        String input = SCANNER.nextLine().replaceAll("\\s+", "");
        return splitInput(input);
    }

    public static String[] splitInput(String input) {
        validateNotNull(input);
        String[] stringNumbers = input.split(DELIMETER);
        return stringNumbers;
    }


    private static void validateNotNull(String input) {
        if (isBlank(input)) {
            throw new IllegalArgumentException(BLINK_INPUT_ERROR);
        }
    }

    private static boolean isBlank(String input) {
        return (input == null || input.trim().isEmpty());
    }
}
