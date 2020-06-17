package step2.model;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoTotalCalculator {
    private final LottoPrizes lottoPrizes;
    private final LottoWinning lottoWinning;
    private final Lottos lottos;

    private LottoTotalCalculator(Lottos lottos, LottoWinning lottoWinning) {
        this.lottoWinning = lottoWinning;
        this.lottos = lottos;
        this.lottoPrizes = LottoPrizes.of(lottos, lottoWinning);
    }

    public static LottoTotalCalculator of (Lottos lottos, LottoWinning winningLotto) {
        return new LottoTotalCalculator(lottos, winningLotto);
    }

    public Stream<LottoPrize> stream() {
        return lottoPrizes.stream();
    }

    public long getPayoff () {
        return stream().mapToLong(LottoPrize::getTotalPrize).sum();
    }

    public double resultLottoGamePayOffRatio () {
        return (double)getPayoff() / lottos.getPrice();
    }
}
