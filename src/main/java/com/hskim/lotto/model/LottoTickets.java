package com.hskim.lotto.model;

import java.util.*;
import java.util.stream.Collectors;

public class LottoTickets {
    private static final String LOTTO_TICKET_JOINING_DELIMITER = "\n";

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    public LottoTickets mergeTickets(LottoTickets target) {
        lottoTickets.addAll(target.lottoTickets);

        return this;
    }

    public String makeLottoTicketsString() {
        return lottoTickets.stream()
                .map(Object::toString)
                .collect(Collectors.joining(LOTTO_TICKET_JOINING_DELIMITER));
    }

    public int getTicketsSize() {
        return lottoTickets.size();
    }

    public List<LottoWinTable> getWinTableList(LottoWinningTicket winningTicket) {

        return lottoTickets.stream()
                .map(lottoTicket -> mapToWinnerTable(winningTicket, lottoTicket))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }

    private Optional<LottoWinTable> mapToWinnerTable(LottoWinningTicket winningTicket, LottoTicket lottoTicket) {
        return LottoWinTable.find(winningTicket.getWinningCondition(lottoTicket.getLottoNumberList()));
    }

    public int getTotalTicketPrice() {
        return lottoTickets.size() * LottoTicket.LOTTO_PRICE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoTickets)) return false;
        LottoTickets that = (LottoTickets) o;
        return Objects.equals(lottoTickets, that.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}
