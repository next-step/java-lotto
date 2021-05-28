package step2.model;

import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public long getPrice() {
        return lottos.size() * Lotto.PRICE;
    }

    public List<LottoPrize> getCalculate(LottoWinning lottoWinning) {
        return Arrays.stream(LottoRank.values())
            .map(rank -> LottoPrize.of(rank, getWinningCount(rank, lottoWinning)))
            .collect(toList());
    }

    public long getWinningCount(LottoRank rank, LottoWinning lottoWinning) {
        return lottos.stream()
            .map(lottoWinning::getRankOfLotto)
            .filter(rank::equals)
            .count();
    }

    public double resultLottoGamePayOffRatio(List<LottoPrize> lottoPrizes) {
        return (double) getPayoff(lottoPrizes) / getPrice();
    }

    private long getPayoff(List<LottoPrize> lottoPrizes) {
        return lottoPrizes.stream().mapToLong(LottoPrize::getTotalPrize).sum();
    }
}
