import java.util.regex.Pattern;

public class PatternFormula {
    private final static String ENTER_REGEX = "(\\n)";
    private final static String CUSTOM_SEPARATOR_REGEX = "(\\/\\/.)";
    private final static int SEPARATOR_INDEX = 0;
    private final static int NUMBER_FORMULA_INDEX = 1;
    
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
        final String separator = patternFormula.split(ENTER_REGEX)[SEPARATOR_INDEX];
        if (!Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(separator).find()) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_CUSTOM_SEPARATE.getMessage());
        }
        final int separatorLength = separator.length();
        return separator.substring(separatorLength - 1, separatorLength);
    }
    
    public String getNumberFormula() {
        return patternFormula.split(ENTER_REGEX)[NUMBER_FORMULA_INDEX];
    }
}
