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
}

// 1. 1,2:3;4 -> [1], [2:3;4]
    // 2. 1 -> [1]
    // 3. 2:3;4 -> [2:3], [4]
      // 4. 2:3 -> [2], [3]
        // 5. 2 -> [2]
        // 6. 3 -> [3]
      // 7. 4 -> [4]