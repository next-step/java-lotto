package calculator;

class StringCalculator {
    public int calc(String input) {
        String[] parsed = input.split(" ");
        int result = Integer.parseInt(parsed[0]);

        for (int i = 1; i < parsed.length; i += 2) {
            StringOperator operator = StringOperator.of(parsed[i]);
            int target = Integer.parseInt(parsed[i + 1]);
            result = operator.calc(result, target);
        }

        return result;
    }
}
