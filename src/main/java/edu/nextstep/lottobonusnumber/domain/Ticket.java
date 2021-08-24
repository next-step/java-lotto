package edu.nextstep.lottobonusnumber.domain;

import java.util.List;
import java.util.stream.Stream;

public class Ticket {

    private final List<Integer> numbers;

    public static final int TICKET_PRICE = 1_000;

    public Ticket(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public static Ticket madeBy(NumbersMaker numbersMaker) {
        return null;
    }

    public Stream<Integer> stream() {
        return numbers.stream();
    }

    public int countMatchingNumbers(Ticket winningTicket) {
        return 0;
    }
}
