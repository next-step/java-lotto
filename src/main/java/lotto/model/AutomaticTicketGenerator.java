package lotto.model;

import java.util.*;

public class AutomaticTicketGenerator implements TicketGenerator {
    @Override
    public Ticket generate() {
        List<Ball> candidates = new ArrayList<>();
        for (int i = Ball.MINIMUM_VALUE; i <= Ball.MAXIMUM_VALUE; i++) {
            candidates.add(Ball.valueOf(i));
        }

        Collections.shuffle(candidates);
        candidates = candidates.subList(0, Ticket.SIZE);
        Set<Ball> balls = new HashSet<>(candidates);

        return Ticket.generateTicket(balls);
    }
}
