package calculator.domain;

/**
 * @author : 0giri
 * @since : 2023/04/26
 */
public class Number {

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public int value() {
        return this.value;
    }
}
