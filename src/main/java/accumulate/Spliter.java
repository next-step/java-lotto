package accumulate;

public class Spliter {
    private final static String SEPARATOR_JOINER = "";
    private final static int SEPARATOR_INDEX = 0;
    private final static int FORMULA_INDEX = 1;
    
    private final Separators separators;
    
    public Spliter(final String... separators) {
        this.separators = new Separators(String.join(SEPARATOR_JOINER, separators));
    }
    
    public String[] split(final String formula) {
        return separators.getSplitStrings(formula);
    }
}
