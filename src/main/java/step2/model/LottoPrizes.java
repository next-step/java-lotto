package step2.model;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoPrizes {

    private final List<LottoPrize> lottoPrizes;

    private LottoPrizes(List<LottoPrize> lottoPrizes) {
        this.lottoPrizes = lottoPrizes;
    }

    public static LottoPrizes of(Lottos lottos, LottoWinning lottoWinning) {
        return new LottoPrizes(LottoRank.stream()
                .map(rank -> LottoPrize.of(rank, lottos.getWinningCount(rank, lottoWinning)))
                .collect(toList()));
    }

    public Stream<LottoPrize> stream() {
        return this.lottoPrizes.stream();
    }
}
