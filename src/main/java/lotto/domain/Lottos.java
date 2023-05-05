package lotto.domain;

import lotto.enums.LottoPrize;
import lotto.strategy.LottoStrategy;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static lotto.constants.Constants.ZERO;

public class Lottos {

    private final List<Lotto> lottoList;

    public Lottos(LottoStrategy lottoStrategy, int count) {
        lottoList = createLotto(lottoStrategy, count);
    }

    private List<Lotto> createLotto(LottoStrategy lottoStrategy, int count) {
        return IntStream.range(ZERO, count)
                .mapToObj(i -> new Lotto(lottoStrategy.generateNumbers()))
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public Map<LottoPrize, Integer> getMatchCounts(Lotto winnerLotto) {
        return lottoList.stream()
                .map(lotto -> editMatchCount(lotto, winnerLotto))
                .filter(Objects::nonNull)
                .collect(Collectors.toMap(
                        prize -> prize,
                        prize -> 1,
                        Integer::sum,
                        () -> new EnumMap<>(LottoPrize.class)
                ));
    }

    public LottoPrize editMatchCount(final Lotto lotto, final Lotto winnerLotto) {
        return LottoPrize.valueOf(lotto.countMatch(winnerLotto.getLottoNumbers()));
    }
}
