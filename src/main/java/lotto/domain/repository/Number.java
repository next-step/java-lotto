package lotto.domain.repository;

public class Number implements Comparable<Number> {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(Number compared) {
        return Integer.compare(number, compared.number);
    }
}
