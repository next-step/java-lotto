package step1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private static final int splitValueIndex = 1;
    private static final int stringIndex = 2;
    private static final String defaultSplitValue = ",|;";
    private static final  Pattern pattern = Pattern.compile("//(.)\n(.*)");

    public String[] splitValue(String inputValue){
        Matcher m = pattern.matcher(inputValue);
        if (m.find()) {
            String newSplitValue = m.group(splitValueIndex);
            return m.group(stringIndex).split(newSplitValue);
        }
        return inputValue.split(defaultSplitValue);
    }

}
