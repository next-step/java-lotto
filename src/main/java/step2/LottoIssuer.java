package step2;

import java.util.*;

public class LottoIssuer {

    public List<LottoTicket> issueTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new LottoTicket(issueTicket()));
        }
        return tickets;
    }

    public List<LottoTicket> issueTicketsByMoney(int money) {
        int count = money / 1000;
        return issueTickets(count);
    }

    private Set<Lotto> issueTicket() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= 45; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        return numbers.subList(0, 6).stream()
                .map(Lotto::new)
                .collect(java.util.stream.Collectors.toSet());
    }
}
