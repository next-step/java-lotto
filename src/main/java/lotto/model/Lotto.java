package lotto.model;

import java.util.Objects;

public class Lotto implements Comparable<Lotto> {

    private final int number;

    public Lotto(int number) {
        this.number = number;
    }

    public String print() {
        return String.valueOf(this.number);
    }

    @Override
    public int compareTo(Lotto other) {
        return Integer.compare(number, other.number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lotto lotto = (Lotto) o;
        return number == lotto.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}