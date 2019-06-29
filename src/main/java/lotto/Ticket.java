package lotto;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ticket {
    static final String OUT_OF_SIZE_MESSAGE = "Ticket에 담길 수 있는 Ball의 갯수가 아닙니다.";
    public static final int SIZE = 6;

    private final Set<Ball> balls;

    public Ticket(Set<Ball> balls) {
        checkSize(balls);
        this.balls = balls;
    }

    private void checkSize(Set<Ball> ballList) {
        if (ballList.size() != SIZE) {
            throw new IllegalArgumentException(OUT_OF_SIZE_MESSAGE);
        }
    }

    public int match(Ticket other) {
        Set<Ball> otherSet = new HashSet<>(other.balls);
        otherSet.retainAll(balls);

        return otherSet.size();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ticket)) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(balls, ticket.balls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(balls);
    }
}

