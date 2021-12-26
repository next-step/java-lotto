package lotto.service;

import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoTicket;
import lotto.domain.LottoTickets;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoVendingMachine {

    private static final LottoVendingMachine LOTTO_VENDING_MACHINE = new LottoVendingMachine();

    private LottoVendingMachine() {
    }

    public static LottoVendingMachine getInstance() {
        return LOTTO_VENDING_MACHINE;
    }

    public LottoTickets sell(int counts) {
        return LottoTickets.of(generateRandomLottoTicket(counts));
    }

    private List<LottoTicket> generateRandomLottoTicket(int counts) {
        return IntStream.range(0, counts)
                .mapToObj(i -> new LottoTicket(LottoNumberGenerator.generate()))
                .collect(Collectors.toList());
    }

}
