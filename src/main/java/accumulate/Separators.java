package accumulate;

class Separators {
    private String separators;
    
    Separators(String separators) {
        this.separators = separators;
    }
    
    void add(String separator) {
        separators += separator;
    }
    
    String[] getSplitStrings(String formula) {
        return formula.split("[" + separators + "]");
    }
    
    boolean has(String separator) {
        return separators.contains(separator);
    }
}