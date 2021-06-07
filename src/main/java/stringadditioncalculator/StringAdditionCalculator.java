package stringadditioncalculator;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAdditionCalculator {

    public String input() {
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public void output(int sum) {
        System.out.println(sum);
    }

    public int one(String text) {
        if (text.matches("\\d+")) {
            int number = Integer.parseInt(text);
            System.out.println(number);
            return number;
        }
        throw new RuntimeException();
    }

    public int colon(String text) {
        String[] tokens = text.split(",|:");
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("")) {
                tokens[i] = "0";
            }
        }
        return sum(tokens);
    }

    private int sum(String[] numbers) {
        int sum = 0;
        for (String s : numbers) {
            int number = Integer.parseInt(s);
            sum += number;
        }
        output(sum);
        return sum;
    }

    public int custom(String text) {
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        int sum = 0;
        if (m.find()) {
            String customDelimiter = m.group(1);
            String delimiters = customDelimiter + "|,|:";
            String[] tokens = m.group(2).split(delimiters);
            sum = sum(tokens);
        }
        output(sum);
        return sum;
    }

    public int add(String text) {
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
        if (text.contains("//") && text.contains(("\n"))) {
            return custom(text);
        }
        if (text.contains(":") || text.contains(",")) {
            return colon(text);
        }
        throw new RuntimeException();
    }
}
