package edu.nextstep.lottobonusnumber.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Tickets {
    private List<Ticket> tickets;

    public static Tickets of(Payment payment, NumbersMaker numbersMaker) {
        return null;
    }

    public Stream<Ticket> stream() {
        return tickets.stream();
    }

    public Map<Prize, Integer> checkWinningResult(Ticket winningTicket, BonusNumber bonusNumber) {
        return null;
    }
}
