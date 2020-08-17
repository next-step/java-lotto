package com.hskim.lotto.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoTickets {
    private static final String LOTTO_TICKET_JOINING_DELIMITER = "\n";

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(PurchasePrice purchasePrice, LottoNumberMaker numberMaker) {
        this.lottoTickets = makeLottoTickets(purchasePrice, numberMaker);
    }

    public LottoTickets(List<LottoTicket> lottoTickets) {
        this.lottoTickets = lottoTickets;
    }

    private List<LottoTicket> makeLottoTickets(PurchasePrice purchasePrice, LottoNumberMaker numberMaker) {
        GameNumber gameNumber = purchasePrice.getGameNum();
        List<LottoTicket> result = new LinkedList<>();
        while (gameNumber.isPlayable()) {
            List<Integer> lottoNumbers = numberMaker.makeNumbers(LottoTicket.LOTTO_NUMBERS_SIZE);
            result.add(new LottoTicket(lottoNumbers));
            gameNumber.playGame();
        }

        return result;
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
        return winningTicket.findWinnerTable(lottoTicket);
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
