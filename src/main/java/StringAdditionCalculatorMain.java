import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculatorMain {
    public static void main(String[] args) {
//        StringAdditionCalculator calculator = new StringAdditionCalculator();
//        String text = calculator.input();
//        calculator.add(text);

        int custom = add("//;\n1;2,3");
        System.out.println(custom);
    }
    public static int one(String text) {
        if (text.matches("\\d+")) {
            int number = Integer.parseInt(text);
            System.out.println(number);
            return number;
        }
        throw new RuntimeException();
    }

    public static int colon(String text) {
        String[] tokens = text.split(",|:");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("")) {
                tokens[i] = "0";
            }
        }
        return sum(tokens);
    }
    public static int add(String text) {
        if (text == null || text.isEmpty()) {
            System.out.println(0);
            return 0;
        }
        if (text.contains("-")) {
            throw new RuntimeException();
        }
        if (text.length() == 1) {
            return one(text);
        }
        if (text.contains(":") || text.contains(",")) {
            return colon(text);
        }
        if (text.contains("//") && text.contains(("\n"))) {
            return custom(text);
        }
        throw new RuntimeException();
    }
    private static int sum(String[] numbers) {
        int sum = 0;
        for (String s : numbers) {
            int number = Integer.parseInt(s);
            sum += number;
        }
        System.out.println(sum);
        return sum;
    }

    public static int custom(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        int sum = 0;
        if (m.find()) {
            String customDelimiter = m.group(1);
            String delimiters = customDelimiter + "|,|:";
            String[] tokens = m.group(2).split(delimiters);
            sum = sum(tokens);
        }
        System.out.println(sum);
        return sum;
    }
}
