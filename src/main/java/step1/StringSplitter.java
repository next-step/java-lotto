package step1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplitter implements Splitter{
    private static final String DEFAULT_DELIMITERS = ",|:";
    private static final Pattern DEFAULT_PATTERN = Pattern.compile(DEFAULT_DELIMITERS);
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    @Override
    public List<String> splitStringIntoList(String given) {
        Matcher customMatcher = CUSTOM_PATTERN.matcher(given);
        Matcher defaultMatcher = DEFAULT_PATTERN.matcher(given);
        List<String> tokens = new ArrayList<>();

        if(customMatcher.find()){
            String customDelimiter = customMatcher.group(1);
            tokens = Arrays.asList(customMatcher.group(2).split(customDelimiter));
        }
        if(defaultMatcher.find()){
            tokens = Arrays.asList(given.split(DEFAULT_DELIMITERS));
        }
        if(given.length()==1){
            tokens.add(given);
        }
        return tokens;
    }
}
