public class Spliter {
    private final static String ENTER_REGEX = "(\\n)";
    private final static String SEPARATOR_JOINER = "";
    private final static int SEPARATOR_INDEX = 0;
    private final static int FORMULA_INDEX = 1;
    
    private final Separators separators;
    
    public Spliter(final String... separators) {
        this.separators = new Separators(String.join(SEPARATOR_JOINER, separators));
    }
    
    public String[] split(final String formula) {
        return separators.getSplitStrings(separateFormulaAndSeparator(formula));
    }
    
    private String separateFormulaAndSeparator(final String formula) {
        final String[] splitStrings = formula.split(ENTER_REGEX);
        separators.add(splitStrings[SEPARATOR_INDEX]);
        return splitStrings[FORMULA_INDEX];
    }
}
