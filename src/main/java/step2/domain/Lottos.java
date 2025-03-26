package step2.domain;

import step2.util.LottoStrategy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;

    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos generateLottos(int count, LottoStrategy strategy) {
        return new Lottos(IntStream.range(0, count)
                .mapToObj(i -> new Lotto(strategy.generateLottoNumbers()))
                .collect(Collectors.toList()));
    }

    public static int countLottoByAmount(int amount) {
        return amount / LOTTO_PRICE;
    }

    public int size() {
        return lottos.size();
    }
}
