package StringCalculator;

public class Operand {
    private int operand;

    public Operand(int operand) {
        this.operand = operand;
    }

    public Operand(String operand) {
        this.operand = toInt(operand);
    }

    private int toInt(String operand) {
        return Integer.parseInt(operand);
    }

    public Operand calculrate(Operator operator, Operand intputNumber) {
        return new Operand(operator.calculate(this.operand, intputNumber.operand));
    }

    public int parseInt() {
        return this.operand;
    }
}
