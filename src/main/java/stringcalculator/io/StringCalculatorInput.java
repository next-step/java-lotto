package stringcalculator.io;

import java.util.Scanner;

public class StringCalculatorInput {

    public static String[] input(final String separator) {
        Scanner scanner = new Scanner(System.in);
        String text = scanner.nextLine();
        if (text.isBlank()) {
            throw new RuntimeException();
        }
        return split(text, separator);
    }

    public static String[] split(final String text, final String separator) {
        String[] result = text.split(separator);
        if (result.length != 1 && result.length % 2 == 0) {
            throw new RuntimeException();
        }
        return result;
    }

}
