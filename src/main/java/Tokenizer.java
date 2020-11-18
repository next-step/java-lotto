import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tokenizer {
    private final String newSplitValue = "";
    private final String defaultSplitValue = ",|;";

    public String[] splitValue(String inputValue){
        Matcher m = Pattern.compile("//(.)\n(.*)").matcher(inputValue);
        if (m.find()) {
            String customDelimiter = m.group(1);
            return m.group(2).split(customDelimiter);
        }
        return inputValue.split(defaultSplitValue);
    }

}
