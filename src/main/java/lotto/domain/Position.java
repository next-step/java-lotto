package lotto.domain;

import java.util.Objects;

public class Position {
    private static int FIRST_POSITION = 0;
    private static int LAST_POSITION = 5;

    private final int value;

    public Position(int value) {
        if(value < FIRST_POSITION || value > LAST_POSITION) {
            throw new IllegalArgumentException();
        }
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Position)) return false;
        Position thatPosition = (Position) o;
        return value == thatPosition.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
