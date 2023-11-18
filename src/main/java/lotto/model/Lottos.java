package lotto.model;

import java.util.List;

public class Lottos {
    public static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos;

    public Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public int lottoCount() {
        return this.lottos.size();
    }

    public List<Lotto> lottoList() {
        return this.lottos;
    }

    public int totalPurchasePrice() {
        return this.lottos.size() * LOTTO_PRICE;
    }

    public int correctCount(WinnerNumbers winnerNumbers, int correctCount) {
        return (int)lottos.stream()
                .filter(lotto -> lotto.isMatch(winnerNumbers, correctCount))
                .count();
    }

}
