package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Lottos(int lottoCount) {
        this.lottos = makeLottos(lottoCount);
    }

    private List<Lotto> makeLottos(int lottoCount) {
        List<Lotto> lottos = new ArrayList<>();
        IntStream.range(0, lottoCount).forEach(value -> lottos.add(new Lotto()));
        return lottos;
    }

    public List<Lotto> lottos() {
        return lottos;
    }

    public void rank(Lotto winningLotto) {
        lottos.forEach(lotto -> lotto.rank(winningLotto));
    }

    public int countByRanking(Ranking ranking) {
        return (int) lottos.stream().filter(lotto -> lotto.ranking() == ranking).count();
    }

    public double profitRate() {
        double profits = 0;
        for (Ranking ranking : Ranking.ranked()) {
            profits += profitsPerRanking(ranking);
        }

        return profitRateFormat(profits / payment());
    }

    private int profitsPerRanking(Ranking ranking) {
        return countByRanking(ranking) * ranking.profit();
    }

    private int payment() {
        return lottos.size() * Lotto.PRICE;
    }

    private double profitRateFormat(double result) {
        return Math.floor(result * 100) / 100.0;
    }

    public boolean isLoss() {
        return profitRate() < 1;
    }
}