package lotto.model;

import java.util.List;

public class Lottery {
    private final List<Integer> winnerNumbers;
    private final List<Lotto> lottos;

    public Lottery(List<Integer> winnerNumbers, List<Lotto> lottos) {
        this.winnerNumbers = winnerNumbers;
        this.lottos = lottos;
    }


}
