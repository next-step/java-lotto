package com.hskim.lotto.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoTickets {
    private static final int LOW_BOUND = 1;
    private static final int UPPER_BOUND = 45;
    private static final String LOTTO_TICKET_JOINING_DELIMITER = "\n";

    private final List<LottoTicket> lottoTickets;

    public LottoTickets(PurchasePrice purchasePrice, NumberMaker numberMaker) {
        this.lottoTickets = makeLottoTickets(purchasePrice, numberMaker);
    }

    private List<LottoTicket> makeLottoTickets(PurchasePrice purchasePrice, NumberMaker numberMaker) {
        GameNumber gameNumber = purchasePrice.getGameNum();
        List<LottoTicket> result = new LinkedList<>();
        while (gameNumber.isPlayable()) {
            List<String> lottoNumbers = numberMaker.makeNumbers(LOW_BOUND, UPPER_BOUND, LottoTicket.LOTTO_NUMBERS_SIZE);
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

    public String makeTicketsSizeString() {
        return String.valueOf(lottoTickets.size());
    }

    public Stream<LottoTicket> getLottoTicketStream() {
        return lottoTickets.stream();
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
