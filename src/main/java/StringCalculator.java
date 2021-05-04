import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {

    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public int one(String text) {
        if (text.matches("\\d+")) {
            int number = Integer.parseInt(text);
            return number;
        }
        throw new RuntimeException();
    }

    public int colon(String text) {
        String[] tokens = text.split(",|:");
        for (int i=0;i<tokens.length;i++) {
            if (tokens[i] == "") {
                tokens[i] = "0";
            }
        }
        return sum(tokens);
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            sum += number;
        }
        return sum;
    }

    public int custom(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        int sum = 0;
        if (m.find()) {
            String customDelimiter = m.group(1);
            String[] tokens = m.group(2).split(customDelimiter);
            sum = sum(tokens);
        }
        return sum;
    }

    public int add(String text) {
        if (text == null || text.isEmpty()) {
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
}
