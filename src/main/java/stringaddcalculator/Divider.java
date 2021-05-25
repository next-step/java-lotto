package stringaddcalculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Divider {
    private final int CUSTOM_DELIMITER_IDX = 1;
    private final int TARGET_NUM_IDX = 2;
    private final String CUSTOM_DELIMITER = "//(.)\n(.*)";
    private List<String> DELIMITER = new ArrayList<>(Arrays.asList(",", ":"));
    private Matcher matcher;
    private String expression;

    public Divider(String input) {
        this.matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(input);
        this.init(input);
    }

    private void init(String input){
        if(this.matcher.find()){
            this.addCustomDelimiter(this.matcher.group(CUSTOM_DELIMITER_IDX));
            this.expression=this.matcher.group(TARGET_NUM_IDX);
            return;
        }
        this.expression=input;
    }

    public String expression() {
       return this.expression;
    }

    public void addCustomDelimiter(String customDelimiter) {
        this.DELIMITER.add(customDelimiter);
    }

    public String[] getDividedInput(String num) {
        String delimiterRegex = "([" + String.join("", DELIMITER) + "])";
        return num.split(delimiterRegex);
    }

}
