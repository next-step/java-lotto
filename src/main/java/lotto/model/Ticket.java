package lotto.model;

import java.util.*;

public class Ticket {
    static final String OUT_OF_SIZE_MESSAGE = "Ticket에 담길 수 있는 Ball의 갯수가 아닙니다.";
    public static final int SIZE = 6;

    private final Set<Ball> balls;

    private Ticket(Set<Ball> balls) {
        checkSize(balls);
        this.balls = balls;
    }

    public static Ticket generateTicket(Set<Ball> balls) {
        return new Ticket(balls);
    }

    public static Ticket generateRandomTicket() {
        List<Ball> candidates = new ArrayList<>();
        for (int i = Ball.MINIMUM_VALUE; i <= Ball.MAXIMUM_VALUE; i++) {
            candidates.add(Ball.valueOf(i));
        }

        Collections.shuffle(candidates);
        candidates = candidates.subList(0, SIZE);
        Set<Ball> balls = new HashSet<>(candidates);

        return new Ticket(balls);
    }

    private void checkSize(Set<Ball> balls) {
        if (balls.size() != SIZE) {
            throw new IllegalArgumentException(OUT_OF_SIZE_MESSAGE + ": " + balls);
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