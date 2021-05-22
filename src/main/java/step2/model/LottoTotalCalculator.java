package step2.model;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class LottoTotalCalculator {

    private final List<LottoPrize> lottoPrizes;
    private final LottoWinning lottoWinning;
    private final Lottos lottos;

    private LottoTotalCalculator(Lottos lottos, LottoWinning lottoWinning) {
        this.lottoWinning = lottoWinning;
        this.lottos = lottos;
        this.lottoPrizes = LottoRank.stream()
            .map(rank -> LottoPrize.of(rank, getWinningCount(rank)))
            .collect(toList());
    }

    public static LottoTotalCalculator of(Lottos lottos, LottoWinning winningLotto) {
        return new LottoTotalCalculator(lottos, winningLotto);
    }

    private long getWinningCount(LottoRank rank) {
        return lottos.stream()
            .map(lottoWinning::getRankOfLotto)
            .filter(rank::equals)
            .count();
    }

    public Stream<LottoPrize> stream() {
        return lottoPrizes.stream();
    }

    public long getPayoff() {
        return stream().mapToLong(LottoPrize::getTotalPrize).sum();
    }

    public double resultLottoGamePayOffRatio() {
        return (double) getPayoff() / lottos.getPrice();
    }
}