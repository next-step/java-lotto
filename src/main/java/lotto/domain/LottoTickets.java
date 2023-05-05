package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoTickets {
    public static final int PRICE_OF_LOTTO_TICKET = 1000;

    private final List<LottoTicket> tickets;

    public LottoTickets(List<LottoTicket> tickets) {
        this.tickets = tickets;
    }

    public static LottoTickets create(int purchaseAmount) {
        validate(purchaseAmount);
        int numberOfTickets = Math.floorDiv(purchaseAmount, PRICE_OF_LOTTO_TICKET);
        List<LottoTicket> tickets = generateLottoTickets(numberOfTickets);
        return new LottoTickets(tickets);
    }

    private static void validate(int purchaseAmount) {
        if (purchaseAmount < PRICE_OF_LOTTO_TICKET) {
            throw new IllegalArgumentException(String.format("티켓 구입 금액은 최소 %d원 이상 이여야 합니다", PRICE_OF_LOTTO_TICKET));
        }
    }

    private static List<LottoTicket> generateLottoTickets(int numberOfTickets) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < numberOfTickets; i++) {
            tickets.add(LottoGenerator.generateLottoNumbers());
        }
        return tickets;
    }

    public WinningStatistics calculateLottoStatistics(WinningLotto winningLotto, BonusNumber bonusNumber) {
        WinningStatistics winningStatistics = new WinningStatistics();
        for (LottoTicket lottoTicket : tickets) {
            WinningRank rank = winningLotto.match(lottoTicket, bonusNumber);
            winningStatistics.addMatchedTicket(rank);
        }
        return winningStatistics;
    }


    public List<LottoTicket> getLottoTickets() {
        return Collections.unmodifiableList(tickets);
    }

    public int findLottoTicketCount() {
        return this.tickets.size();
    }
}

