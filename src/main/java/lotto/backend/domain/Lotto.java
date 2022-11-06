package lotto.backend.domain;

import lotto.backend.domain.generator.AutoNumberGenerator;
import lotto.backend.domain.generator.CustomNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

public class Lotto {

    public static final int PRICE_PER_LOTTO = 1000;
    private final Money money;
    private final LottoTickets lottoTickets = new LottoTickets();

    public Lotto(int money) {
        this.money = new Money(money);
    }

    public LottoTickets buy(List<List<Integer>> customLottoNumbers) {
        int totalCount = money.howManyLottoTickets(PRICE_PER_LOTTO);
        lottoTickets.add(buyCustomLotto(customLottoNumbers));
        lottoTickets.add(buyAutoLotto(totalCount - customLottoNumbers.size()));
        return lottoTickets;
    }

    private List<LottoTicket> buyAutoLotto(int count) {
        return IntStream.range(0, count)
                .mapToObj(i -> LottoTicket.create(new AutoNumberGenerator()))
                .collect(toList());
    }

    private List<LottoTicket> buyCustomLotto(List<List<Integer>> customNumbers) {
        return customNumbers.stream()
                .map(i -> LottoTicket.create(new CustomNumberGenerator(i)))
                .collect(Collectors.toList());
    }

    public LottoResult match(List<Integer> winningNumber, int bonus) {
        LottoStatistics lottoStatistics = LottoStatistics.of(WinningLotto.of(winningNumber, bonus), lottoTickets);
        LottoProfit lottoProfit = LottoProfit.of(lottoStatistics.prizeAmount(), money);
        return new LottoResult(lottoStatistics, lottoProfit);
    }
}
