package calculator.domain;

public class Number {

    private final int value;

    public Number(int value) {
        this.value = value;
    }

    public Number(String value) {
        if (value == null) {
            throw new IllegalArgumentException("null 은 허용하지 않습니다.");
        }
        this.value = Integer.parseInt(value);
    }

    public int value() {
        return this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number number = (Number) o;
        return this.value == number.value;
    }
}
