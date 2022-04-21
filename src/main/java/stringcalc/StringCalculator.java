package stringcalc;

public class StringCalculator {
    public int execute(String stringForCalculation) {
        validateInput(stringForCalculation);

        IntegerAndArithmeticStrings strings = new IntegerAndArithmeticStrings(stringForCalculation.split(" "));

        return strings.calculate();
    }

    private void validateInput(String stringForCalculation) {
        if (stringForCalculation == null || stringForCalculation.isEmpty()) {
            throw new IllegalArgumentException("유효하지 않은 문자열");
        }
    }

}
