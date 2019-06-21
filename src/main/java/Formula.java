class Formula {
    private final static String SPLIT_REGEX_COMMA = ",";
    private final static String SPLIT_REGEX_COLON = ":";
    private final String formula;
    
    Formula(String formula) {
        this.formula = formula;
    }
    
    String[] getSeparatedNumber() {
        return formula.replace(SPLIT_REGEX_COLON, SPLIT_REGEX_COMMA).split(SPLIT_REGEX_COMMA);
    }
    
    String getCustomSeparator() {
        String customSeparator = formula.split("n")[0];
        return customSeparator.substring(customSeparator.length() - 2, customSeparator.length() - 1);
    }
}
