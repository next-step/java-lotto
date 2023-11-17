package lotto.model;

import java.util.List;

public class Lottos {
    private static final int LOTTO_PRICE = 1000;
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
        int result = 0;
        for (Lotto lotto : lottos) {
            result += lotto.match(winnerNumbers, correctCount);
        }
        return result;
    }

}
