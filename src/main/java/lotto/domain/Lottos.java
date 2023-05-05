package lotto.domain;

import lotto.enums.LottoPrize;
import lotto.strategy.LottoStrategy;

import java.util.List;
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

//    private void updateMatchCounts() {
//        lottoList.forEach(this::editMatchCount);
//    }

//    private void editMatchCount(final Lotto lotto) {
//        int countOfMatch = lotto.countMatch(winnerLotto.getLottoNumbers());
//
//        if (countOfMatch < MIN_MATCHES || countOfMatch > MAX_MATCHES) {
//            return;
//        }
//
//        LottoPrize prize = LottoPrize.valueOf(countOfMatch);
//        matchCounts.compute(prize, (key, value) -> value == null ? 1 : value + 1);
//    }

}
