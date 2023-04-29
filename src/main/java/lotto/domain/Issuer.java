package lotto.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Issuer {
    private final Random RANDOM = new Random();
    private final List<UserTicket> userTickets;

    public Issuer() {
        this.userTickets = new ArrayList<>();
    }

    public void issueTickets(int ticketCount) {
        for (int i = 0; i < ticketCount; i++) {
            userTickets.add(new UserTicket(issueNumbers()));
        }
    }

    private Set<Integer> issueNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < 6) {
            numbers.add(issueNumber());
        }
        return numbers;
    }

    private int issueNumber() {
        return RANDOM.nextInt(46) + 1;
    }

    public List<UserTicket> issuedTickets() {
        return userTickets;
    }

    public Statics issuedTicketStatistics(WinnerTicket winnerTicket) {
        return new Statics(userTickets, winnerTicket);
    }
}
