package textcalculator;

import java.util.regex.Pattern;

public class TextCalculator {

    private static final Pattern VALID_FORMULA_PATTERN = Pattern.compile("^\\d+( [+\\-*/] \\d+)*$");

    private final String formula;

    public TextCalculator(String formula){
        this.formula = formula;
        if(validateFormula()){
            throw new IllegalArgumentException("+ - * / 연산자만 가능하며 숫자와 연산자 사이엔 공백이 존재해야 합니다");
        }
    }

    private boolean validateFormula() {
        return !VALID_FORMULA_PATTERN.matcher(formula).matches();
    }

}
