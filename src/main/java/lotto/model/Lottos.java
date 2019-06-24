package lotto.model;

import java.util.List;

public class Lottos {

    private List<PickNumbers> lottoNumbers;

    public Lottos(List<PickNumbers> lottos) {
        lottoNumbers = lottos;
    }

    public Aggregate aggregate(WinningNumbers winnerNumbers) {
        Aggregate aggregate = new Aggregate();
        for (PickNumbers pickNumbers : lottoNumbers) {
            aggregate.put(pickNumbers.compare(winnerNumbers));
        }
        return aggregate;
    }
}
