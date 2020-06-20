package step2.model;

import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Lottos {

    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos of(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public long getPrice() {
        return lottos.size() * Lotto.PRICE;
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public int getCount() {
        return lottos.size();
    }

    public long getWinningCount (LottoRank rank, LottoWinning lottoWinning) {
        return lottos.stream()
                .map(lottoWinning::getRankOfLotto)
                .filter(rank::equals)
                .count();
    }

    public void addLottos(Lottos lottos) {
        this.lottos.addAll(lottos.stream().collect(toList()));
    }

}
