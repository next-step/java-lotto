package stringcaculator.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Delimeter {
    private final Input input;

    private Matcher matcher;

    public Delimeter(Input input) {
        this.input = input;
    }

    public boolean useCustomDelimeter() {
        this.matcher = Pattern.compile(DELEMETER_REGEX.CUSTOM.toString()).matcher(input.getValue());
        return matcher.find();
    }

    public String[] splitedInput(){
        if (useCustomDelimeter()) {
            return this.matcher.group(2).split(matcher.group(1));
        }
        return input.splitedInput(DELEMETER_REGEX.GENERAL);
    }
}
