import java.util.regex.Pattern;

public class PatternFormula {
    private final static String ENTER_REGEX = "(\\n)";
    private final static int SEPARATOR_INDEX = 0;
    
    private String patternFormula;
    
    public PatternFormula(final String patternFormula) {
        this.patternFormula = patternFormula;
    }
    
    public boolean matchPattern(final String regex) {
        return Pattern.compile(regex)
          .matcher(patternFormula)
          .find();
    }
    
    public String getCustomSeparator() {
        final String[] splitStrings = patternFormula.split(ENTER_REGEX);
        final String separator = splitStrings[SEPARATOR_INDEX];
        final int separatorLength = separator.length();
        return separator.substring(separatorLength - 1, separatorLength);
    }
}
