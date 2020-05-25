package step1;

public class StringAddCalculator {

    private final static int INITIAL_VALUE = 0;

    public static int splitAndSum(String input) {
        return splitAndSum(Formula.valueOf(input));
    }

    public static int splitAndSum(Formula formula) {
        if (formula.isBlank()) {
            return Operand.ZERO_VALUE;
        }

        return FormulaSplitter.split(formula).stream()
                .map(Operand::toPositiveInt)
                .reduce(INITIAL_VALUE, Integer::sum);
    }
}
