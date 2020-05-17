package calculator;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Calculator {

    public long calculate(String input, String regex) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        return Stream.of(input.split(regex)).map(this::parseToken).reduce(0, Integer::sum);
    }

    public long calculate(String input){
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        List<Integer> nums= getTokens(input);
        return nums.stream().reduce(0, Integer::sum);
    }
    private List<Integer> getTokens(final String input){
        String tokens = input;
        String splitter = ",|;";

        Pattern pattern = Pattern.compile("//(.)\\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if(matcher.matches()){
            splitter =  matcher.group(1);
            tokens = matcher.group(2);
        }

        return Stream.of(tokens.split(splitter)).map(this::parseToken).collect(Collectors.toList());
    }

    private Integer parseToken(String token) {
        Integer val = parseToInteger(token);
        if (val <= 0) {
            throw new IllegalArgumentException(String.format("%s is invalid format", token));
        }
        return val;
    }

    private Integer parseToInteger(String token) {
        try {
            return Integer.parseInt(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s is invalid format", token));
        }
    }

}
