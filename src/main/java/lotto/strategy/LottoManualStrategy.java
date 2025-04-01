package lotto.strategy;

import java.util.List;

import lotto.domain.Lotto;
import lotto.exception.LottoGenerationException;
import lotto.vo.LottoManualTicket;

import static java.util.stream.Collectors.toList;

public class LottoManualStrategy implements LottoGenerationStrategy {
    private final List<LottoManualTicket> ticket;

    public LottoManualStrategy(List<LottoManualTicket> ticket) {
        validation(ticket);
        this.ticket = ticket;
    }

    private void validation(List<LottoManualTicket> ticket) {
        if (ticket == null) {
            throw new LottoGenerationException();
        }
    }

    @Override
    public List<Lotto> generateLottos() {
        return ticket.stream()
            .map(LottoManualTicket::getNumbers)
            .map(Lotto::new)
            .collect(toList());
    }
}
