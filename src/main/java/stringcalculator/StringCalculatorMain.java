package stringcalculator;

import static stringcalculator.StringCalculator.formula;
import static stringcalculator.StringCalculator.result;

public class StringCalculatorMain {

    public static void main(String[] args) {
        while (!isEnd()) {}
    }

    private static boolean isEnd() {
        try {
            System.out.print(result(new Formula(formula())));
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

}
