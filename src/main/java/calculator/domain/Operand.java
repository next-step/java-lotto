package calculator.domain;

/**
 * @author : 0giri
 * @since : 2023/04/26
 */
public class Operand implements ExpressionElement{

    private final int value;

    public Operand(String value) {
        this.value = Integer.parseInt(value);
    }

    public int value() {
        return this.value;
    }
}
