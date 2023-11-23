package step2.domain;

import java.util.*;

public class LottoIssuer {

    private final List<Integer> numbers = new ArrayList<>();
    private final int BASE_MONEY = 1000;

    public LottoIssuer() {
        for (int i = LottoNumber.LOTTO_NUM_START; i <= LottoNumber.LOTTO_NUM_END; i++) {
            numbers.add(i);
        }
    }

    public List<LottoTicket> issueTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new LottoTicket(issueTicket()));
        }
        return tickets;
    }

    public List<LottoTicket> issueTicketsByMoney(int money) {
        int count = money / BASE_MONEY;
        return issueTickets(count);
    }

    private Set<LottoNumber> issueTicket() {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6).stream()
                .sorted()
                .map(LottoNumber::new)
                .collect(java.util.stream.Collectors.toSet());
    }
}
