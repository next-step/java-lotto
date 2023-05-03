package lotto.dto;

import lotto.domain.Lotto;
import lotto.domain.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketInfo {

    private final List<String> ticketInfo;

    private LottoTicketInfo(List<String> ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public static LottoTicketInfo from(LottoTicket lottoTicket) {
        List<String> ticketInfo = lottoTicket.getLottos().stream()
                .map(Lotto::toString)
                .collect(Collectors.toList());
        return new LottoTicketInfo(ticketInfo);
    }

    public List<String> getTicketInfo() {
        return Collections.unmodifiableList(ticketInfo);
    }
}
