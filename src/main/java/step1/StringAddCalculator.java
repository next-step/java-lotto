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
        if(input == null || input.isEmpty()) {
            return 0;
        }
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
        if(m.find()){
            delimiter = m.group(1);
            input = m.group(2);
        }
        return Arrays.stream(input.split(delimiter))
                .mapToInt(i-> Integer.parseInt(i))
                .sum();
    }
}
