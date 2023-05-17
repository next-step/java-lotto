package lotto.dto;

import lotto.domain.LottoTicket;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LottoTicketInfo {

    private final List<LottoInfo> ticketInfo;

    private LottoTicketInfo(List<LottoInfo> ticketInfo) {
        this.ticketInfo = ticketInfo;
    }

    public static LottoTicketInfo from(LottoTicket lottoTicket) {
        List<LottoInfo> ticketInfo = lottoTicket.getLottos().stream()
                .map(LottoInfo::from)
                .collect(Collectors.toList());
        return new LottoTicketInfo(ticketInfo);
    }

    public List<LottoInfo> getTicketInfo() {
        return Collections.unmodifiableList(ticketInfo);
    }
}
