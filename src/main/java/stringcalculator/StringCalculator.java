package stringcalculator;

import java.io.InputStream;
import java.util.Scanner;

public class StringCalculator {

    public static final InputStream DEFAULT_INPUT_STREAM = System.in;
    private static Scanner scanner = new Scanner(DEFAULT_INPUT_STREAM);

    public static int result(Formula formula) {
        formula.split();
        formula.calculate();
        return formula.result().value();
    }

    public static String formula() {
        return formula(DEFAULT_INPUT_STREAM);
    }

    private static String formula(InputStream inputStream) {
        if (!inputStream.equals(DEFAULT_INPUT_STREAM)) {
            scanner = new Scanner(inputStream);
        }
        return scanner.nextLine();
    }

}
