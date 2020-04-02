package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoMachine {
    public static List<LottoTicket> pay(long money) {
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < getTicketCount(money); i++) {
            lottoTickets.add(generateLottoTicket());
        }
        return lottoTickets;
    }

    private static LottoTicket generateLottoTicket() {
        return new LottoTicket(LottoMixer.mixLottoNumbers());
    }

    private static long getTicketCount(long money) {
        return money / LottoTicket.PRICE;
    }

    public static List<LottoTicket> pay(int money, List<LottoTicketForm> lottoTicketForms) {
        List<LottoTicket> result = new ArrayList<>();
        money = (int) (money - lottoTicketForms.size() * LottoTicket.PRICE);
        List<LottoTicket> autoLottoTickets = pay(money);
        List<LottoTicket> manualLottoTickets = lottoTicketForms.stream()
                .map(LottoTicket::ofForm)
                .collect(Collectors.toList());
        result.addAll(autoLottoTickets);
        result.addAll(manualLottoTickets);
        return result;
    }
}
