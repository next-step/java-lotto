package lotto.domain.lotto;

import lotto.domain.winning.WinningStatistics;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private int lottosCount;
    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottosCount = lottos.size();
        this.lottos = lottos;
    }

    public static Lottos withMoney(int money) {
        int lottosCount = money / Lotto.PRICE;
        List<Lotto> lottos = IntStream.range(0, lottosCount)
                .mapToObj(i -> LottoGenerator.getRandomLotto())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        return new Lottos(lottos);
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public int getCount() {
        return lottosCount;
    }

    public WinningStatistics getWinningStatistics(WinningLotto lastWonLotto) {
        WinningStatistics statistics = WinningStatistics.zero();
        lottos.forEach(lotto -> {
            statistics.increaseWinningLottoCount(lotto.getWinningCount(lastWonLotto.getLotto()),
                    lotto.hasNumber(lastWonLotto.getBonusLottoNumber()));
        });
        return statistics;
    }

    public List<Lotto> getLottoNumbers() {
        return lottos;
    }
}
