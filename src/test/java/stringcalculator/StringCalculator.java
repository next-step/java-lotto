package stringcalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
    private static final String OPERATION_REGEX = "[+\\-*/]+";
    private static final String NUMBER_REGEX = "\\d+";

    public static int calculate(String input) {
        List<Integer> numbers = toInts(getCharacters(input, NUMBER_REGEX));
        List<String> operations = getCharacters(input, OPERATION_REGEX);
        int result = numbers.get(0);
        for (int i = 0; i < operations.size(); i++) {
            if (operations.get(i).equals("+")) {
                result += numbers.get(i + 1);
            }
            if (operations.get(i).equals("-")) {
                result -= numbers.get(i + 1);
            }
            if (operations.get(i).equals("*")) {
                result *= numbers.get(i + 1);
            }
            if (operations.get(i).equals("/")) {
                result /= numbers.get(i + 1);
            }
        }
        return result;
    }

    private static List<String> getCharacters(String input, String regex) {
        List<String> operations = new ArrayList<>();

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            String op = matcher.group();
            operations.add(op);
        }
        return operations;
    }

    private static List<Integer> toInts(List<String> strings) {
        List<Integer> ints = new ArrayList<>();
        for (String string : strings) {
            ints.add(Integer.parseInt(string));
        }
        return ints;
    }
}
