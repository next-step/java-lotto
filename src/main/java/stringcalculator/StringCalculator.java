package stringcalculator;

import java.io.InputStream;
import java.util.Scanner;
import stringcalculator.Formula.SplitFormula;

public class StringCalculator {

    public static final InputStream DEFAULT_INPUT_STREAM = System.in;
    private static Scanner scanner = new Scanner(DEFAULT_INPUT_STREAM);

    public static int result(Formula formula) {
        return toInt(formulaResult(calculation(splitFormula(formula))));
    }

    private static Formula calculation(Formula formula) {
        formula.calculate();
        return formula;
    }

    private static Formula splitFormula(Formula formula) {
        new SplitFormula().split(formula);
        return formula;
    }

    private static int toInt(Number result) {
        return result.value();
    }

    private static Number formulaResult(Formula formula) {
        return formula.result();
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
