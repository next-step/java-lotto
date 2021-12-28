package lotto.service;

import lotto.domain.LottoNumberGenerator;
import lotto.domain.LottoNumbers;
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
        return LottoTickets.of(generateRandomLottoNumbers(counts));
    }

    private List<LottoNumbers> generateRandomLottoNumbers(int counts) {
        return IntStream.range(0, counts)
                .mapToObj(i -> LottoNumberGenerator.generate())
                .collect(Collectors.toList());
    }

}
