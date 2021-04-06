package lotto.factories;

import lotto.domain.LottoTickets;
import lotto.utils.StringUtil;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsFactory {
    public static LottoTickets from(final List<String> lottoTicketsInput) {
        return new LottoTickets(
                lottoTicketsInput.stream()
                        .map(StringUtil::splitCommas)
                        .map(LottoTicketFactory::from)
                        .collect(Collectors.toList())
        );
    }
}
