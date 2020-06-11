package step1;

public class StringAddCalculator {
    private Formula formula;

    public StringAddCalculator(Formula formula) {
       this.formula = formula;
    }

    public int sum() {
        int total = 0;
        for (Integer number : formula.getFormulaNumbers()) {
            total += number;
        }

        return total;
    }


}
