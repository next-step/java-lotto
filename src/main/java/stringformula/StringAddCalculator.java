package stringformula;

public class StringAddCalculator {
    public Number calculate(String formula) {
        return SumFormula.of(formula)
                .result();
    }
}
