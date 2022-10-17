package com.nextstep.lotto.lottoGame.domain;

import com.nextstep.lotto.lottoGame.view.InputView;
import com.nextstep.lotto.lottoGame.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int LOTTO_TICKET_PRICE = 1000;

    private List<LottoTicket> tickets;

    public LottoGame(List<LottoTicket> tickets) {
        this.tickets = tickets;
        OutputView.drawPublishResult(tickets);
    }

    public static LottoGame byBudget() {
        int budget = InputView.getBudget();
        int ticketCount = getAvailableTicketCount(budget);
        return new LottoGame(publishAutoTickets(ticketCount));
    }

    private static List<LottoTicket> publishAutoTickets(int ticketCount) {
        List<LottoTicket> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            tickets.add(new LottoTicket());
        }
        return tickets;
    }

    private static int getAvailableTicketCount(int budget) {
        return budget / LOTTO_TICKET_PRICE;
    }

    public void result() {
        List<Integer> winningNumbers = InputView.getLottoNumbers();
        List<Rank> ranks = tickets.stream()
                .map(ticket -> ticket.rank(winningNumbers))
                .filter(rank -> rank != Rank.NONE)
                .collect(Collectors.toList());

        LottoResult result = new LottoResult(ranks);
        OutputView.drawResult(result, tickets.size() * LOTTO_TICKET_PRICE);
    }

}
