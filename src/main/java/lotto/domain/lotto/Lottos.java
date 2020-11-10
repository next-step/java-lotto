package lotto.domain.lotto;

import lotto.domain.exception.ManualLottoCountOverMoneyException;
import lotto.domain.winning.WinningStatistics;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int MINIMUM_AUTO_LOTTO_COUNT = 0;
    private int lottosCount;
    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottosCount = lottos.size();
        this.lottos = lottos;
    }

    public static Lottos withMoney(Money money) {
        int lottosCount = getLottoCount(money);
        List<Lotto> lottos = getLottosByAuto(lottosCount);
        return new Lottos(lottos);
    }

    private static List<Lotto> getLottosByAuto(int lottosCount) {
        validateAutoLottoCount(lottosCount);
        List<Lotto> lottos = IntStream.range(0, lottosCount)
                .mapToObj(i -> LottoGenerator.getRandomLotto())
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        return lottos;
    }

    private static void validateAutoLottoCount(int lottosCount) {
        if (lottosCount < MINIMUM_AUTO_LOTTO_COUNT) {
            throw new ManualLottoCountOverMoneyException();
        }
    }

    private static int getLottoCount(Money money) {
        return money.getAmount() / Lotto.PRICE;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public static Lottos buy(Money money, List<List<Integer>> manualLottoNumbers) {
        return merge(getLottosByManual(manualLottoNumbers),
                getLottosByAuto(getLottoCount(money) - manualLottoNumbers.size()));
    }

    private static List<Lotto> getLottosByManual(List<List<Integer>> manualLottoNumbers) {
        return manualLottoNumbers.stream()
                .map(Lotto::ofNumbers)
                .collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
    }

    private static Lottos merge(List<Lotto> manualLottos, List<Lotto> autoLottos) {
        List<Lotto> lottos = new ArrayList<>();
        lottos.addAll(manualLottos);
        lottos.addAll(autoLottos);
        return new Lottos(Collections.unmodifiableList(lottos));
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
