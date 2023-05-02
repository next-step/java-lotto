package StringCalculator.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculatorView {

    private final static Pattern SPACE = Pattern.compile(" ");
    private static final Scanner scanner = new Scanner(System.in);

    public static List<String> inputExpression() {
        return Arrays.asList(SPACE.split(scanner.nextLine()));
    }

    public static void outputCalculate(Integer result) {
        System.out.println(result);
    }

}
