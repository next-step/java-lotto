package step1;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

    private static final String DEFAULT_DELIMITER = ",|:";

    private String delimiter;

    public StringAddCalculator(){
        this(DEFAULT_DELIMITER);
    }

    public StringAddCalculator(String delimiter){
        this.delimiter = delimiter;
    }

    public int sum(String input) {
        if(emptyCheck(input)) return 0;
        input = patternCheck(input);
        return Arrays.stream(input.split(delimiter))
                .mapToInt(i-> {
                    int result = Integer.parseInt(i);
                    if(Integer.parseInt(i) < 0) throw new RuntimeException();
                    return result;
                }).sum();
    }

    private boolean emptyCheck(String input){
        return input == null || input.isEmpty();
    }

    private String patternCheck(String input){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()){
            delimiter = m.group(1);
            input = m.group(2);
        }
        return input;
    }

}
