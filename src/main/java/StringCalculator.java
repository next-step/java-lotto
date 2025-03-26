import java.util.Arrays;

public class StringCalculator {

    private static final String DELIMITER = " ";
    public static String[] splitString(String str) {
        return str.split(DELIMITER);
    }

    public static int calculate(String[] strs) {
        Arrays.stream(strs).forEach(System.out::println);

        int result = Integer.parseInt(strs[0]);

        for(int i = 1; i < strs.length; i+=2) {
            System.out.println("### " + i + " ###");
            String operator = strs[i];
            int nextNumber = Integer.parseInt(strs[i + 1]);
            System.out.println(String.format("%d %s %d", result, operator, nextNumber));
            switch (operator) {
                case "+":
                    result += nextNumber;
                    break;
                case "-":
                    result -= nextNumber;
                    break;
                case "*":
                    result *= nextNumber;
                    break;
                case "/":
                    result /= nextNumber;
                    break;
                default:
                    throw new IllegalArgumentException("지원하지 않는 연산자입니다. " + operator);
            }
            System.out.println(String.format("%d", result, operator, nextNumber));
        }

        return result;
    }
}
