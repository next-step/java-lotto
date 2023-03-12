package Calculator;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringCalculator {
    private static Pattern p = Pattern.compile("^[0-9]+$");

    public int add(String text) {
        String[] splitString;

        if (text == null || text.isEmpty()) {
            return 0;
        }

        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
        if (m.find()) {
            String customDelimeter = m.group(1);
            splitString = m.group(2).split(customDelimeter);
            return sumNumber(splitString);
        }

        splitString = text.split(":|,");
        return sumNumber(splitString);
    }

    private static int sumNumber(String[] splitString) {
        return getSplitNumbers(splitString)
                .stream()
                .mapToInt(i -> i)
                .sum();
    }

    private static List<Integer> getSplitNumbers(String[] splitString) {
        return Arrays.stream(splitString)
                .map(i -> {
                    if (!p.matcher(i).find()) throw new RuntimeException();
                    return Integer.parseInt(i);
                })
                .collect(Collectors.toList());
    }
}