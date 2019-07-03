package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ManualTicketGenerator implements TicketGenerator {
    private List<Integer> numbers;

    public ManualTicketGenerator(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    @Override
    public Ticket generate() {
        return Ticket.generateTicket(numbers.stream()
                .map(Ball::valueOf)
                .collect(Collectors.toSet()));
    }
}
