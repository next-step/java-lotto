package step1.model;

public class ConvertFormulaString {

    private final String formula;
    private static final String SPLIT_REGEX = " ";

    public ConvertFormulaString(String formula) {
        this.formula = formula;
    }

    public String[] get() {
        if (formula.isEmpty()) {
            throw new IllegalArgumentException("입력 된 연산식이 없습니다.");
        }

        return this.formula.split(SPLIT_REGEX);
    }
}
