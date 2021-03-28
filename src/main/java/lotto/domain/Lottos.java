package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> Lottos;

    public Lottos(int purchaseAmount) {
        this.Lottos = new ArrayList<>();
    }

    public Lottos(List<Lotto> lottos) {
        this.Lottos = lottos;
    }

    public List<Rank> winningResults(WinningNumber winningNumber) {
        return new ArrayList<Rank>();
    }
}
