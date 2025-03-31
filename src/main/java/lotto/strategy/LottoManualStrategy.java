package lotto.strategy;

import lotto.domain.Lotto;
import lotto.exception.LottoGenerationException;
import lotto.vo.LottoManualTicket;

import static java.util.stream.Collectors.toList;

public class LottoManualStrategy implements LottoGenerationStrategy {
    private final LottoManualTicket ticket;

    public LottoManualStrategy(LottoManualTicket ticket) {
        validation(ticket);
        this.ticket = ticket;
    }

    private void validation(LottoManualTicket ticket) {
        if (ticket == null) {
            throw new LottoGenerationException("수동 로또 티켓이 존재하지 않습니다.");
        }
    }

    @Override
    public Lotto generate() {
        return new Lotto(ticket.getNumbers()
            .stream()
            .sorted()
            .collect(toList()));
    }
}
