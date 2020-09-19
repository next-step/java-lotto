package lotto.domain;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.toList;

/**
 * 역할 - 입력받은 금액에 해당하는 로또 티켓들을 생성한다.
 */
public class LottoTicketMachine {
    private static final int LOTTO_PRICE = 1_000;
    private static final List<LottoNumber> lottoNumbers;
    static {
        lottoNumbers = Stream.iterate(1, n -> n + 1)
                .limit(45)
                .map(LottoNumber::new)
                .collect(toList());
    }

    public LottoPack issueTickets(int money) {
        int ticketCount = calculateTicketCount(money);
        return Stream.generate(this::issueTicket)
                .limit(ticketCount)
                .collect(collectingAndThen(toList()
                        , lottoTickets -> new LottoPack(LOTTO_PRICE, lottoTickets)));
    }

    private LottoTicket issueTicket() {
        shuffleNumbers();
        return new LottoTicket(new HashSet<>(lottoNumbers.subList(0, 6)));
    }

    private int calculateTicketCount(int money) {
        if (money < LOTTO_PRICE) {
            throw new IllegalArgumentException("구입금액이 부족합니다.");
        }

        return money / LOTTO_PRICE;
    }

    private void shuffleNumbers() {
        Collections.shuffle(lottoNumbers);
    }
}
