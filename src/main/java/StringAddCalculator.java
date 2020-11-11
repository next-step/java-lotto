import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
    private static String splitDelimiter;
    private static String target;
    public static int splitAndSum(String text) throws Exception {
        splitDelimiter = "[,:]";
        target = text;

        if(isBlank(target))
            return 0;

        changeDelimiterAndTargetIfAvailable(text);

        if(isSingleInteger(target))
            return Integer.parseInt(target);

        List<String> numbers = Arrays.asList(target.split(splitDelimiter));

        if(hasInappropriateValue(numbers))
            throw new RuntimeException();

        return numbers.stream().mapToInt(Integer::parseInt).sum();
    }

    private static boolean hasInappropriateValue(List<String> numbers) {
        return numbers.stream().filter(n -> Integer.parseInt(n) < 0).findAny().isPresent()
                || numbers.stream().filter(n -> !isNumeric(n)).findAny().isPresent();
    }

    private static void changeDelimiterAndTargetIfAvailable(String text) {
        Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(text);

        if(matcher.find()){
            splitDelimiter = matcher.group(1);
            target = matcher.group(2);
        }
    }

    private static boolean isSingleInteger(String text) {
        if(text.split(splitDelimiter).length != 1)
            return false;
        if(!isNumeric(text))
            throw new RuntimeException();

        return true;
    }

    private static boolean isNumeric(String text) {
        try {
            Integer.parseInt(text);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    private static boolean isBlank(String text) {
        return text == null || text.trim().length() == 0;
    }
}
