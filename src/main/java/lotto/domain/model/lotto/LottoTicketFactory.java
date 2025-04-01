package lotto.domain.model.lotto;

import lotto.domain.strategy.LottoNumberGeneratorStrategy;
import lotto.domain.strategy.RandomLottoNumberGeneratorStrategy;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketFactory {

    private final LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy;

    public LottoTicketFactory() {
        this.lottoNumberGeneratorStrategy = new RandomLottoNumberGeneratorStrategy();
    }

    public LottoTicketFactory(final LottoNumberGeneratorStrategy lottoNumberGeneratorStrategy) {
        this.lottoNumberGeneratorStrategy = lottoNumberGeneratorStrategy;
    }

    public List<LottoTicket> create(final int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> new LottoTicket(lottoNumberGeneratorStrategy.generate()))
                .collect(Collectors.toList());
    }

    public WinningLottoTicket createWinning(
            final Set<LottoNumber> winningNumbers, final BonusNumber bonusNumber) {
        return new WinningLottoTicket(winningNumbers, bonusNumber);
    }
}
