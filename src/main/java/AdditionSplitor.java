public class AdditionSplitor {
    private final static String SPLIT_REGEX_COMMA = ",";
    private final static String SPLIT_REGEX_COLON = ":";
    
    public static String[] split(Formula formula) {
        return formula.getSeparatedNumber();
    }
}
