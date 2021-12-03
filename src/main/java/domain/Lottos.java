package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static controller.LottoGame.*;
import static domain.Prize.*;

public class Lottos {

    private final List<Lotto> lottos;

    public Lottos(int totalNumberOfLottos) {
        this.lottos = new ArrayList<>();

        IntStream.range(STARTING_INDEX_LOTTOS, totalNumberOfLottos)
                .forEach(i -> lottos.add(Lotto.of()));
    }

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public Stream<Lotto> stream() {
        return lottos.stream();
    }

    public double profitRate(Lotto winningNumber) {
        int investment = PRICE_OF_LOTTO * lottos.size();

        return (double) totalProfit(winningNumber) / investment;
    }

    private int totalProfit(Lotto winningNumber) {
        lottos.forEach(it -> countPrize(it.compareWithWinningNumber(winningNumber)));

        return sumProfit();
    }
}
