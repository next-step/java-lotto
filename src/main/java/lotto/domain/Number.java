package lotto.domain;

import org.jetbrains.annotations.NotNull;

public class Number implements Comparable<Number> {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public int compareTo(@NotNull Number o) {
        return Integer.compare(this.number, o.number);
    }
}
