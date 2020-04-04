package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoTicket.TICKET_PRICE;

public class LottoMachine {
    public static List<LottoTicket> createLottoTickets(Money money) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < getTicketCount(money); i++) {
            lottoTickets.add(generateLottoTicket());
        }
        return lottoTickets;
    }

    private static LottoTicket generateLottoTicket() {
        return new LottoTicket(LottoMixer.mixLottoNumbers());
    }

    private static long getTicketCount(Money money) {
        return money.divide(TICKET_PRICE);
    }

    public static List<LottoTicket> createLottoTickets(Money money, LottoTicketForms lottoTicketForms) {
        Money leftMoney = deductManualPrice(money, lottoTicketForms);
        List<LottoTicket> manualLottoTickets = createManualLottoTickets(lottoTicketForms);
        List<LottoTicket> autoLottoTickets = createLottoTickets(leftMoney);

        List<LottoTicket> lottoTickets = new ArrayList<>();
        lottoTickets.addAll(manualLottoTickets);
        lottoTickets.addAll(autoLottoTickets);
        return lottoTickets;
    }

    private static List<LottoTicket> createManualLottoTickets(LottoTicketForms lottoTicketForms) {
        return lottoTicketForms.getLottoTicketForms()
                .stream()
                .map(LottoTicket::ofForm)
                .collect(Collectors.toList());
    }

    private static Money deductManualPrice(Money money, LottoTicketForms lottoTicketForms) {
        return money.minus(TICKET_PRICE.multiply(lottoTicketForms.getSize()));
    }
}
