package step2.domain;

import java.util.List;

public class Lotto {

    private List<Number> numbers;
    private int count;

    public Lotto(List<Number> numbers) {
        this.numbers = numbers;
    }

    public void equalCheck(Number number) {
        if (numbers.contains(number)) count++;
    }

    public List<Number> getNumbers() {
        return numbers;
    }

    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Lotto that = (Lotto) o;

        return numbers != null ? numbers.equals(that.numbers) : that.numbers == null;
    }

    @Override
    public int hashCode() {
        return numbers != null ? numbers.hashCode() : 0;
    }

    @Override
    public String toString() {
        return numbers.toString();
    }
}
