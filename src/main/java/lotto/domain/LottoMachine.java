package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static lotto.domain.LottoTicket.*;

public class LottoMachine {
    public static List<LottoTicket> pay(Money money) {
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

    public static List<LottoTicket> pay(Money money, List<LottoTicketForm> lottoTicketForms) {
        List<LottoTicket> result = new ArrayList<>();
        Money leftMoney = money.minus(TICKET_PRICE.multiply(lottoTicketForms.size()));
        List<LottoTicket> autoLottoTickets = pay(leftMoney);
        List<LottoTicket> manualLottoTickets = lottoTicketForms.stream()
                .map(LottoTicket::ofForm)
                .collect(Collectors.toList());
        result.addAll(autoLottoTickets);
        result.addAll(manualLottoTickets);
        return result;
    }
}
