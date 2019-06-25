package accumulate;

import java.util.regex.Pattern;

public class PatternFormula {
    private final static String PATTERN_FORMULA_REGEX = "(\\/\\/.\\\\(n))?((\\d+)(,|:|.))+(\\d+)";
    private final static String DEFAULT_SEPARATORS = ",:"; 
    private final static String ENTER_REGEX = "(\\\\n)";
    private final static String CUSTOM_SEPARATOR_REGEX = "(\\/\\/.)";
    private final static int SEPARATOR_INDEX = 0;
    private final static int NUMBER_FORMULA_INDEX = 1;
    private final static int SEPARETOR_MAX_LENGTH = 3;
    private final static int ZERO_INDEX = 0;
    private final static int BEFORE_INDEX = 1;
    private final static int ARRAY_SIZE_ONE = 1;
    
    private NumberFormula numberFormula;    
    private Separators separators;
    
    public PatternFormula(final String patternFormula) {
        if (!matchPattern(patternFormula)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_VALUE.getMessage());
        }
        separators = new Separators(DEFAULT_SEPARATORS + getCustomSeparator(patternFormula));
        numberFormula = getNumberFormula(patternFormula);
    }
    
    private static boolean matchPattern(String patternFormula) {
        return patternFormula.matches(PATTERN_FORMULA_REGEX);
    }
    
    private static String getCustomSeparator(String patternFormula) {
        if (!hasCustomSeparatorAt(patternFormula)) {
            return "";
        }
        final String separator = patternFormula.split(ENTER_REGEX)[SEPARATOR_INDEX];
        if (!canSeparateCustomSeparator(separator)) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_CUSTOM_SEPARATE.getMessage());
        }
        final int separatorLength = separator.length();
        return separator.substring(separatorLength - BEFORE_INDEX, separatorLength);
    }
    
    private static boolean hasCustomSeparatorAt(String patternFormula) {
        return patternFormula.split(ENTER_REGEX).length > ARRAY_SIZE_ONE;
    }
    
    private static boolean canSeparateCustomSeparator(String separator) {
        boolean correctLength = separator.length() == SEPARETOR_MAX_LENGTH;
        boolean correctPattern = Pattern.compile(CUSTOM_SEPARATOR_REGEX).matcher(separator).find();
        return correctLength && correctPattern;
    }
    
    private static NumberFormula getNumberFormula(String patternFormula) {
        String[] splitNumberFormula = patternFormula.split(ENTER_REGEX);
        int numberFormulaIndex = hasCustomSeparatorAt(patternFormula) ? NUMBER_FORMULA_INDEX : ZERO_INDEX;
        return new NumberFormula(splitNumberFormula[numberFormulaIndex]);
    }
    
    public String[] getNumberString() {
        return separators.getSplitStrings(numberFormula.getNumberFormula());
    }
    
    public boolean hasCustomSeparator(String separator) {
        return separators.has(separator);
    }
    
    public boolean equalsNumberFormula(String numberFormula) {
        return numberFormula.equals(numberFormula);
    }
}
