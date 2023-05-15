package lotto.domain;

import lotto.enums.LottoPrize;
import lotto.strategy.LottoStrategy;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.Constants.ZERO;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(LottoStrategy lottoStrategy, int count) {
        lottoList = createLotto(lottoStrategy, count);
    }

    public List<Lotto> createLotto(LottoStrategy lottoStrategy, int count) {
        return IntStream.range(ZERO, count)
                .mapToObj(i -> new Lotto(lottoStrategy.generateNumbers()))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Map<LottoPrize, Integer> getMatchCounts(WinnerLotto winnerLotto) {
        return lottoList.stream()
                .map(lotto -> matchCount(lotto, winnerLotto))
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        Function.identity(),
                        prize -> 1,
                        Integer::sum,
                        () -> new EnumMap<>(LottoPrize.class)
                ));
    }

    private LottoPrize matchCount(Lotto lotto, WinnerLotto winnerLotto) {
        boolean bonusNumberMatch = lotto.hasBonusNumber(winnerLotto.getBonusNumber());
        int count = lotto.countMatchNumbers(winnerLotto);
        return LottoPrize.valueOf(count, bonusNumberMatch);
    }

}
