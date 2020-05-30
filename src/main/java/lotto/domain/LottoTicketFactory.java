package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoTicketFactory {

    private LottoTicketFactory() {
    }

    public static List<LottoTicket> createAutoLottoTickets(int autoTicketsCount) {
        return Stream.generate(LottoTicket::createNonDuplicateNumbers)
                .limit(autoTicketsCount)
                .map(LottoTicket::newAutoLottoTicket)
                .collect(Collectors.toList());
    }

    public static LottoTicket createManualLottoTicket(String manualNumbers) {
        List<LottoNumber> nonDuplicateNumbers = LottoTicket.createNonDuplicateNumbers(manualNumbers);
        return LottoTicket.newManualLottoTicket(nonDuplicateNumbers);
    }
}
