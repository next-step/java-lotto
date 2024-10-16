package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    private static final String spaces = "\\s+";
    private static final String number = "\\d+";
    private static final String operation = "[+\\-*/]";

    public static List<Integer> parseNumbers(String calculationString) {
        calculationString = calculationString.replaceAll(spaces, "");

        List<Integer> numbers = new ArrayList<>();

        Pattern pattern = Pattern.compile(number);
        Matcher matcher = pattern.matcher(calculationString);

        while (matcher.find()) {
            String token = matcher.group();

            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }

    public static List<Character> parseOperations(String calculationString) {
        calculationString = calculationString.replaceAll(spaces, "");

        List<Character> operations = new ArrayList<>();

        Pattern pattern = Pattern.compile(operation);
        Matcher matcher = pattern.matcher(calculationString);

        while (matcher.find()) {
            String token = matcher.group();

            operations.add(token.charAt(0));
        }

        return operations;
    }
}
