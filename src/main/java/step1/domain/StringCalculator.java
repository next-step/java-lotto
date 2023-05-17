package step1.domain;

public class StringCalculator {

    public int stringCalculator(InputString text) {
        String[] values = text.getText().split(" ");
        int result = toInt(values[0]);
        for (int i = 2; i < values.length; i += 2) {
            int factor = toInt(values[i]);
            OperatorCode operatorCode = toOperatorCode(values[i - 1]);
            result = operatorCode.calculate(result, factor);
        }
        return result;
    }

    private static OperatorCode toOperatorCode(String value) {
        return OperatorCode.ofCode(value);
    }

    private int toInt(String value) {
        return Integer.parseInt(value);
    }
    
}
