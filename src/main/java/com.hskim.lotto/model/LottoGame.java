package com.hskim.lotto.model;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoGame {
    private static final int LOW_BOUND = 0;
    private static final int UPPER_BOUND = 45;

    private List<LottoTicket> lottoTickets;

    public LottoGame(PurchasePrice purchasePrice, NumberMaker numberMaker) {
        lottoTickets = makeLottoTickets(purchasePrice, numberMaker);
    }

    private List<LottoTicket> makeLottoTickets(PurchasePrice purchasePrice, NumberMaker numberMaker) {
        GameNum gameNum = purchasePrice.getGameNum();
        List<LottoTicket> result = new LinkedList<>();

        while (gameNum.isPlayable()) {
            List<String> lottoNumbers = numberMaker.makeNumbers(LOW_BOUND, UPPER_BOUND, LottoTicket.LOTTO_NUMBERS_SIZE);
            result.add(new LottoTicket(lottoNumbers));
            gameNum.playGame();
        }

        return result;
    }

    public String makeLottoTicketsString() {

        return lottoTickets.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    public String makeTicketsSizeString() {

        return String.valueOf(lottoTickets.size());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LottoGame)) return false;
        LottoGame lottoGame = (LottoGame) o;
        return Objects.equals(lottoTickets, lottoGame.lottoTickets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lottoTickets);
    }
}
