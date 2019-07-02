package lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class Ticket {
    static final String OUT_OF_SIZE_MESSAGE = "Ticket에 담길 수 있는 Ball의 갯수가 아닙니다.";
    static final int SIZE = 6;
    private static final String FORMAT_OF_TICKET = "[%s]";
    private static final String DELIMITER = ", ";

    private final Set<Ball> balls;

    private Ticket(Set<Ball> balls) {
        checkSize(balls);
        this.balls = balls;
    }

    public static Ticket generateTicket(Set<Ball> balls) {
        return new Ticket(balls);
    }

    private void checkSize(Set<Ball> balls) {
        if (balls.size() != SIZE) {
            throw new IllegalArgumentException(OUT_OF_SIZE_MESSAGE + ": " + balls);
        }
    }

    int match(Ticket other) {
        Set<Ball> otherSet = new HashSet<>(other.balls);
        otherSet.retainAll(balls);

        return otherSet.size();
    }

    boolean contains(Ball ball) {
        return balls.contains(ball);
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

    @Override
    public String toString() {
        String string = balls.stream()
                .map(Ball::toInteger)
                .map(Object::toString)
                .collect(Collectors.joining(DELIMITER));
        return String.format(FORMAT_OF_TICKET, string);
    }
}