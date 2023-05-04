package stringcalculator.view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CalculatorView {

    private static final Pattern SPACE = Pattern.compile(" ");
    private static final Scanner SCANNER = new Scanner(System.in);

    public static List<String> inputExpression() {
        return Arrays.asList(SPACE.split(SCANNER.nextLine()));
    }

    public static void outputCalculate(Integer result) {
        System.out.println(result);
    }

}
