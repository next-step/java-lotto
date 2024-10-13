package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputParser {

    public List<Integer> parseNumbers(String calculationString) {
        calculationString = calculationString.replaceAll("\\s+", "");

        List<Integer> numbers = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(calculationString);

        while (matcher.find()) {
            String token = matcher.group();

            numbers.add(Integer.parseInt(token));
        }

        return numbers;
    }

    public List<Character> parseOperations(String calculationString) {
        calculationString = calculationString.replaceAll("\\s+", "");

        List<Character> operations = new ArrayList<>();

        Pattern pattern = Pattern.compile("[+\\-*/]");
        Matcher matcher = pattern.matcher(calculationString);

        while (matcher.find()) {
            String token = matcher.group();

            operations.add(token.charAt(0));
        }

        return operations;
    }
}
