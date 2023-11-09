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

            switch (op) {
                case "+": {
                    result += Integer.parseInt(split[idx]);
                    break;
                }
                case "-": {
                    result -= Integer.parseInt(split[idx]);
                    break;
                }
                case "*": {
                    result *= Integer.parseInt(split[idx]);
                    break;
                }
                case "/": {
                    result /= Integer.parseInt(split[idx]);
                    break;
                }
                default: {
                    throw new RuntimeException();
                }
            }
        }

        return result;
    }
}
