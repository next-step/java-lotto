package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toCollection;

public class Lottos {

    public List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos create(List<Lotto> lottos) {
        return new Lottos(lottos);
    }


    public ArrayList<Rank> getRankList() {
        return lottos.stream().map(lotto -> lotto.getRank())
                              .collect(toCollection(ArrayList::new));
    }

    public void checkWinningNumbers(List<Integer> winningNumbers, int bounsNumber) {
        lottos.stream().forEach( value -> value.findLottoRank(winningNumbers, bounsNumber));

    }
}
