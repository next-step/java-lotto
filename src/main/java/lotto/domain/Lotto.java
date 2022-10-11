package lotto.domain;

import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.domain.LottoNumber.shuffleNumbers;

public class Lotto {

    private final static int COUNT_OF_LOTTO_TICKET_NUMBER = 6;
    private final static int LOTTO_TICKET_PRICE = 1000;
    private final static int LOTTO_TICKET_BUY_MAX_PRICE = 100000;

    private final int payment;

    public Lotto(final int payment) {
        if (payment < LOTTO_TICKET_PRICE || payment > LOTTO_TICKET_BUY_MAX_PRICE) {
            throw new IllegalArgumentException("입력하신 금액이 올바르지 않습니다. (최소 금액:" + LOTTO_TICKET_PRICE + "원, 최대 금액:" + LOTTO_TICKET_BUY_MAX_PRICE + ")");
        }
        this.payment = payment;
    }

    public List<LottoTicket> tickets() {
        return autoIssue();
    }

    private List<LottoTicket> autoIssue() {
        return IntStream.range(0, payment / LOTTO_TICKET_PRICE)
                .mapToObj(i -> new LottoTicket(new TreeSet<>(shuffleNumbers().stream()
                        .limit(COUNT_OF_LOTTO_TICKET_NUMBER)
                        .collect(Collectors.toList()))))
                .collect(Collectors.toUnmodifiableList());
    }

    public int payment() {
        return payment;
    }
}
