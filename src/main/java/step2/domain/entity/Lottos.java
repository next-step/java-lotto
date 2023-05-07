package step2.domain.entity;

import step2.domain.vo.LottoPrize;

import java.util.ArrayList;
import java.util.List;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int size() {
        return this.lottos.size();
    }

    public static int getLottoRankCount(LottoPrize prize, List<LottoPrize> lottoPrizes) {
        return (int) lottoPrizes.stream()
                .filter(lottoPrize -> lottoPrize.equals(prize))
                .count();
    }

    public double getTotalRate(List<LottoPrize> lottoPrizes) {
        double rate = (double) getTotalAmount(lottoPrizes) / getTotalMoney();
        return Math.floor(rate * 100.0) / 100.0;
    }

    private long getTotalAmount(List<LottoPrize> lottoPrizes) {
        return lottoPrizes.stream()
                .mapToLong(LottoPrize::getPrize)
                .sum();
    }

    private int getTotalMoney() {
        return Lotto.PRICE * this.size();
    }

    public WinnerType checkLottoPrize(WinnerLotto winnerLotto) {
        List<LottoPrize> prizes = new ArrayList<>();

        for (Lotto lotto : lottos) {
            final var prize = winnerLotto.prize(lotto);
            prizes.add(prize);
        }

        return new WinnerType(prizes);
    }

    public int getManualLottoQuantity() {
        return (int) this.lottos.stream().filter(Lotto::isManualLotto).count();
    }

    public int getAutoLottoQuantity() {
        return (int) this.lottos.stream().filter(Lotto::isAutoLotto).count();
    }

}
