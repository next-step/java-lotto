package lotto.domain.lotto;

import java.util.ArrayList;
import java.util.List;

import static util.Preconditions.checkArgument;

public class LottoTicketsFactory {
    public static final String COUNT_MUST_NOT_BE_NEGATIVE = "count must not be negative";
    
    public static LottoTicketGroup create(final int count) {
        checkArgument(count >= 0, COUNT_MUST_NOT_BE_NEGATIVE);
        
        if (count == 0) {
            return LottoTicketGroup.EMPTY;
        }

        final List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            final LottoTicket lottoTicket = LottoTicket.of();
            lottoTickets.add(lottoTicket);
        }
        return LottoTicketGroup.of(lottoTickets);
    }
}
