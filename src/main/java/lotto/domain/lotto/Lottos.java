package lotto.domain.lotto;

import lotto.domain.WinningStatistics;
import lotto.domain.exception.InvalidMoneyException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int MINIMUM_MONEY = 0;
    private int lottosCount;
    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottosCount = lottos.size();
        this.lottos = lottos;
    }

    public static Lottos withMoney(int money) {
        validateMoney(money);
        int lottosCount = money / Lotto.PRICE;
        List<Lotto> lottos = IntStream.range(0, lottosCount)
                .mapToObj(i -> Lotto.ofNumbers(LottoNumberGenerator.getNumbers()))
                .collect(Collectors.toList());
        return new Lottos(lottos);
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    private static void validateMoney(int money) {
        if (money < MINIMUM_MONEY) {
            throw new InvalidMoneyException();
        }
    }

    public int getCount() {
        return lottosCount;
    }

    public WinningStatistics getWinningStatistics(List<Integer> lastLottoNumbers) {
        WinningStatistics statistics = WinningStatistics.empty();
        lottos.forEach(lotto -> {
            statistics.increaseWinningLottoCount(lotto.getWinningCount(lastLottoNumbers));
        });
        return statistics;
    }
}
