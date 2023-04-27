package calculator;

class StringCalculator {
    public int calc(InputString inputString) {
        String[] parsed = inputString.parse();
        int result = Integer.parseInt(parsed[0]);
        for (int i = 1; i < parsed.length; i += 2) {
            StringOperator operator = StringOperator.of(parsed[i]);
            result = operator.calc(result, Integer.parseInt(parsed[i + 1]));
        }
        return result;
    }
}
