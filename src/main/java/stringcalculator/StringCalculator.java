package stringcalculator;

public class StringCalculator {

    private Formula formula;

    public StringCalculator(Formula formula) {
        this.formula = formula;
    }

    public void calculate() {
        this.formula.split();
        this.formula.calculate();
    }

    public Number result() {
        return this.formula.result();
    }

}
