public class StringCalculator {
    public static int calculate(String value) {
        String[] split = value.split(" ");
        int result = 0;
        String op = "+";

        for (int idx = 0; idx < split.length; idx++) {
            if (idx % 2 == 1) {
                op = split[idx];
                continue;
            }

            Operator operator = Operator.valueByOperation(op);
            result = operator.operate(result, Integer.parseInt(split[idx]));
        }

        return result;
    }
}
