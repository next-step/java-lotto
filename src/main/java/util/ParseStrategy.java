package util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class ParseStrategy {
    protected String pattern;
    protected Matcher matcher;

    public boolean support(String input) {
        this.matcher = Pattern.compile(pattern).matcher(input);
        return this.matcher.find();
    }

    public abstract List<String> parse();

}
