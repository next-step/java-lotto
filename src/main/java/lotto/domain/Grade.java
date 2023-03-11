package lotto.domain;

public class Grade {
    private int value;

    public Grade(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    public Integer getIntegerGrade() {
        return this.value;
    }

}
