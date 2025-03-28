package lotto.domain;

import lotto.domain.model.LottoTicket;
import lotto.domain.strategy.LottoNumberGeneratorStrategy;
import lotto.domain.strategy.RandomLottoNumberGeneratorStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketMachine {

    private static final int TICKET_PRICE = 1000;
    private final LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy;

    public LottoTicketMachine() {
        this.lottoNumberGeneratorStrategy = new RandomLottoNumberGeneratorStrategy();
    }

    public LottoTicketMachine(final LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        this.lottoNumberGeneratorStrategy = lottoNumberGeneratorStrategy;
    }

    public List<LottoTicket> purchaseTickets(final int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int ticketCount = calculateTicketCount(purchaseAmount);

        return IntStream.range(0, ticketCount)
                .mapToObj(i -> generateTicket())
                .collect(Collectors.toList());
    }

    private int calculateTicketCount(final int purchaseAmount) {
        return purchaseAmount / TICKET_PRICE;
    }

    private void validatePurchaseAmount(final int purchaseAmount) {
        if (purchaseAmount <= 0) {
            throw new IllegalArgumentException("구입 금액은 0보다 커야 합니다.");
        }
    }

    private LottoTicket generateTicket() {
        return new LottoTicket(lottoNumberGeneratorStrategy.generate());
    }
}
