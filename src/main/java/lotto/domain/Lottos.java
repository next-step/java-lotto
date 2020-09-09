package lotto.domain;

import java.util.ArrayList;

import static java.util.stream.Collectors.toCollection;

public class Lottos {

    public ArrayList<Lotto> lottos;

    public Lottos(ArrayList<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(ArrayList<Lotto> lottos) {
        return new Lottos(lottos);
    }


    public void checkWinningNumbers(ArrayList<Integer> winningNumbers) {
        lottos.stream().forEach( value -> value.findLottoRank(winningNumbers));
    }

    public ArrayList<Rank> getRankList() {
        return lottos.stream().map(lotto -> lotto.getRank())
                              .collect(toCollection(ArrayList::new));
    }
}
