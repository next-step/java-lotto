package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.NumberGenerator;
import lotto.view.ResultView;

public class LottoMachine {
    public static final int LOTTO_PRICE = 1000;

    public static List<LottoTicket> purchaseLottoTickets(int ticketsCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketsCount; i++) {
            tickets.add(new LottoTicket(NumberGenerator.generateLottoNumbers()));
        }
        return tickets;
    }

    public static int getTicketsCount(int purchaseAmount){
        return purchaseAmount / LOTTO_PRICE;
    }
}
