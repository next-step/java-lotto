package step2.domain;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoIssuer {

    private static final List<Integer> numbers =
            IntStream.rangeClosed(LottoNumber.LOTTO_NUM_START, LottoNumber.LOTTO_NUM_END)
                    .boxed()
                    .collect(Collectors.toCollection(ArrayList::new));
    private final int BASE_MONEY = 1000;

    public List<LottoTicket> issueTickets(int count) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            tickets.add(new LottoTicket(issueTicket()));
        }
        return tickets;
    }

    public List<LottoTicket> issueTicketsByMoney(int money) {
        if(money < 0 || money % BASE_MONEY != 0) {
            throw new IllegalArgumentException("금액은 0원 이상의 1000원 단위여야 합니다.");
        }
        int count = money / BASE_MONEY;
        return issueTickets(count);
    }

    private Set<LottoNumber> issueTicket() {
        Collections.shuffle(numbers);
        return numbers.subList(0, 6).stream()
                .sorted()
                .map(LottoNumber::new).collect(Collectors.toUnmodifiableSet());
    }
}
