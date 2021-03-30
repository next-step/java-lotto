package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;
    private final int purchaseLotto;

    public Lottos(int purchaseAmount) {
        this.purchaseLotto = purchaseAmount / LOTTO_PRICE;
        this.lottos = generate();
    }

    public Lottos(List<Lotto> lottos) {
        this.purchaseLotto = 0;
        this.lottos = lottos;
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int purchaseLotto() {
        return purchaseLotto;
    }

    public List<Rank> winningResults(WinningNumber winningNumber) {
        List<Rank> result = new ArrayList<>();
        this.lottos.forEach(lotto -> result.add(lotto.winningResult(winningNumber)));
        return result;
    }

    private List<Lotto> generate() {
        List<Lotto> result = new ArrayList<>();
        IntStream.rangeClosed(1, this.purchaseLotto)
                .forEach(i -> result.add(new Lotto()));
        return result;
    }
}
