import java.util.regex.Pattern;

public class PatternFormula {
    private String patternFormula;
    
    public PatternFormula(String patternFormula) {
        this.patternFormula = patternFormula;
    }
    
    public boolean matchPattern(String regex) {
        return Pattern.compile(regex)
          .matcher(patternFormula)
          .find();
    }
}
