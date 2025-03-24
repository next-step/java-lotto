package calculator;


import data.Messages;

public class Calculator {

    private int result = 0;
    private final Formula formula;

    Calculator(int init) {
        this(init, "0");
    }

    public Calculator(String formula) {
        this(0, formula);
    }

    public Calculator(int init, String formula) {
        this.result = init;
        this.formula = new Formula(formula);
    }

    public int getResult() {
        return result;
    }

    public int add(int num) {
        return result += num;
    }

    public int subtract(int num) {
        return result -= num;
    }

    public int multiply(int num) {
        return result *= num;
    }

    public int divide(int num) {
        if (result % num != 0) {
            throw new IllegalArgumentException(Messages.TYPE_ERROR);
        }
        return result /= num;
    }

    public void calculate(String sign, String numStr) {
        int num = Integer.parseInt(numStr);
        switch (sign) {
            case "+":
                add(num);
                return;
            case "-":
                subtract(num);
                return;
            case "*":
                multiply(num);
                return;
            case "/":
                divide(num);
                return;
            default:
                throw new IllegalArgumentException(Messages.TYPE_ERROR);
        }
    }

    public int calculateFormula() {
        String[] calTargetArr = this.formula.getCalculateTarget();
        for (int i = 0; i < calTargetArr.length / 2; i++) {
            this.calculate(calTargetArr[i * 2], calTargetArr[i * 2 + 1]);
        }
        return this.getResult();
    }
}
