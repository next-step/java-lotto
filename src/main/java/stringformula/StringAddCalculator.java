package stringformula;

public class StringAddCalculator {
    private StringAddCalculator() {

    }

    public static Number calculate(String formula) {
        return SumFormula.of(formula)
                .result();
    }
}
