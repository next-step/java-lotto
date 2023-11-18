package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<CorrectNumbers> matchCountAndBonus(WinnerNumbers winnerNumbers) {
        return lottos.stream()
                .map(lotto -> lotto.matchCountAndBonus(winnerNumbers))
                .collect(Collectors.toList());
    }

}
