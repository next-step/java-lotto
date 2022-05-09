package lotto.domain;

import lotto.domain.strategy.LottoNumberGenerateStrategy;
import lotto.exception.InvalidMoneyInputException;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoTicketGenerator {

    public static final int LOTTO_COST_PER_TICKET = 1000;
    private final LottoNumberGenerateStrategy generateStrategy;

    public LottoTicketGenerator(LottoNumberGenerateStrategy generateStrategy) {
        this.generateStrategy = generateStrategy;
    }

    public List<LottoTicket> generateLottoTickets(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> generateLottoTicket())
                .collect(Collectors.toList());
    }

    public List<LottoTicket> buyLottoTickets(int price) {
        return generateLottoTickets(getCountToBuy(price));
    }

    private int getCountToBuy(int price) {
        int count = price / LOTTO_COST_PER_TICKET;
        validInputPrice(count);
        return count;
    }

    private void validInputPrice(int count) {
        if (count == 0) {
            throw new InvalidMoneyInputException();
        }
    }

    public WinningTicket generateWinningTicket(Set<LottoNumber> lottoNumbers, Integer bonusNumber) {
        return new WinningTicket(new LottoTicket(lottoNumbers), new LottoNumber(bonusNumber));
    }

    private Set<LottoNumber> generateLottoNumbers() {
        return generateStrategy.generateLottoNumbers();
    }

    private LottoTicket generateLottoTicket() {
        return new LottoTicket(this.generateLottoNumbers());
    }


}
