package lotto.utils;

import lotto.domain.LottoTicket;
import lotto.factories.LottoTicketFactory;

import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketsUtil {
    public static List<LottoTicket> toLottoTicketsList(final List<String> lottoTicketsInput) {
        return lottoTicketsInput.stream()
                .map(StringUtil::splitCommas)
                .map(LottoTicketFactory::from)
                .collect(Collectors.toList());
    }
}
